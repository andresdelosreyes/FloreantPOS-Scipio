//-AE-
package scipio.xml.services;


import com.floreantpos.model.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;
import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import com.floreantpos.model.dao.RestaurantDAO;
import java.util.List;
import org.apache.log4j.BasicConfigurator;


import scipio.xml.model.Receipt;
import scipio.xml.model.Receipt.Application;
import scipio.xml.model.Receipt.Consumer;
import scipio.xml.model.Receipt.Merchant;
import scipio.xml.model.Receipt.Merchant.Address;
import scipio.xml.model.Receipt.Payment;
import scipio.xml.model.Receipt.Payment.Card;
import scipio.xml.model.Receipt.Pos;
import scipio.xml.model.Receipt.Terminal;
import scipio.xml.model.Receipt.Transaction;
import scipio.xml.model.Receipt.Transaction.Discounts;
import scipio.xml.model.Receipt.Transaction.Discounts.Coupons.Coupon;
import scipio.xml.model.Receipt.Transaction.Items;
import scipio.xml.model.Receipt.Transaction.Items.Item;
import scipio.xml.model.Receipt.Transaction.Salestax;
import scipio.xml.model.Util;

public class ReceiptBuilder {

	public static String ScipioPropertiesFileName = "scipio.properties";
	
	Properties scipio;
	
	private static Logger logger = Logger.getLogger(ReceiptBuilder.class);
	
	public ReceiptBuilder() {
		scipio = getScipioProperties();
	}
	
	public File getApplicationDir() {
		File applicationDir = null;
				
		try {
			applicationDir = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		} catch (URISyntaxException ex) {
			logger.warn(ex.getMessage());
			logger.debug(ex.getStackTrace().toString());
		}
		return applicationDir;
	}
		
	public File getScipioPropertiesFile() throws IOException {
		String path = getApplicationDir().getCanonicalPath() + "/" + ScipioPropertiesFileName;
		return new File(path);
	}
	
	public Properties getScipioProperties() {
		Properties properties = new Properties();
		
		try {
			File scipioPropertiesFile = getScipioPropertiesFile();
			if (scipioPropertiesFile.canRead()) {
				InputStream in = new FileInputStream(getScipioPropertiesFile());
				properties.load(in);
			}
		} catch (FileNotFoundException ex) {
			logger.warn(ScipioPropertiesFileName + "file not found.", ex);
		} catch (IOException ex) {
			logger.warn(ScipioPropertiesFileName + "file not readable.", ex);
		}
		
		return properties;
	}
	
	
	public Receipt createReceipt(Ticket ticket) throws ScipioException, Exception {
		Receipt receipt = new Receipt();
		Restaurant restaurant = RestaurantDAO.getInstance().get(Integer.valueOf(1));
		User user = ticket.getOwner();
		//ScipioInfo scipioInfo = new ScipioInfo();
		
		//TODO: get ScipioInfo from database
		int pin = 1234;
		int tei = 12345;
		int pei = 123456;
		
		//scipioInfo.setPEI(pei);
		//scipioInfo.setPIN(tei);
		//scipioInfo.setTEI(pin);
		
		/* application */
		String appId = scipio.getProperty("application.id");
		Application application = new Application(appId);
		receipt.setApplication(application);
		
		/* pos */
		String posName = scipio.getProperty("pos.name");
		String posVersion = scipio.getProperty("pos.version");
		Pos pos = new Pos(posName, posVersion);
		receipt.setPos(pos);

		/* merchant */
		Merchant merchant = new Merchant();
		merchant.setType("restaurant");
		merchant.setId(scipio.getProperty("merchant.id"));
		merchant.setSmi(scipio.getProperty("merchant.smi"));
		merchant.setAddress(new Address(restaurant.getAddressLine1(), restaurant.getAddressLine2(), restaurant.getAddressLine3()));
		merchant.setTelephone(restaurant.getTelephone());
		merchant.setStoreNumber(restaurant.getId());
		merchant.setUsername(user.getFirstName() + " " + user.getLastName());
		receipt.setMerchant(merchant);
		
		/* terminal */
		receipt.setTerminal(new Terminal(ticket.getTerminal().getId(), ticket.getTerminal().getName()));
		
		/* consumer */
		//Consumer consumer = new Consumer(scipioInfo.getPEI(), scipioInfo.getPIN(), scipioInfo.getTEI());
		//receipt.setConsumer(consumer);
		
		/* transaction */
		Transaction transaction = new Transaction(ticket.getId());
		transaction.setActivated(ticket.getActiveDate());
		transaction.setCreated(ticket.getCreateDate());
		transaction.setClosed(ticket.getClosingDate());
		transaction.setTableNumber(ticket.getTableNumber());
		transaction.setNumberofGuests(ticket.getNumberOfGuests());
		transaction.setServerName(user.getFirstName() + " " + user.getLastName()); // is server the same as owner?
		
		/* transaction items */
		Items items = new Transaction.Items();
		for (TicketItem i : ticket.getTicketItems()) {
			Item item = new Item();
			item.setItemId(i.getItemId());
			item.setDescription(i.getCategoryName() + " " + i.getGroupName() + " " + i.getName() );
			item.setQty(i.getItemCount());
			item.setUnitPrice(i.getUnitPrice());
			logger.info("i.getTotalAmount()" + i.getTotalAmount());
			item.setTotal(i.getTotalAmount());
			logger.info("calculated item total" + Util.multiply(i.getItemCount(), i.getUnitPrice())); //TODO: doesn't handle item discounts
			item.setCoupon(null);  // coupons at item level don't apply
			
			items.getItem().add(item);	
		}
		
		int itemsQty = 0;
		BigDecimal itemsSubtotal = new BigDecimal(0.00);
		for (Item item : transaction.getItems().getItem()) {
			itemsQty += item.getQty();
			itemsSubtotal = itemsSubtotal.add(item.getTotal());
		}
		transaction.getItems().setQuantity(itemsQty);
		transaction.getItems().setSubtotal(itemsSubtotal);
		
		transaction.setItems(items);
	
		/*transaction discounts */
		transaction.setDiscounts(null);
		Discounts discounts = new Transaction.Discounts();
		if (ticket.getCouponAndDiscounts() != null) {
			for (TicketCouponAndDiscount c : ticket.getCouponAndDiscounts()) {
				Coupon coupon = new Coupon();
				coupon.setId(c.getCouponAndDiscountId());
				coupon.setName(c.getName());
				coupon.setQuantity(1); // always 1 even though their might be duplicates
				coupon.setValue(c.getValue());
				discounts.getCoupons().getCoupon().add(coupon);
			}
		}
		transaction.setDiscounts(discounts);
		
		/* Tranaction Tip */
		transaction.setTip(ticket.getGratuity().getAmount());
		
		receipt.setTransaction(transaction);
		
		return receipt;
	}
	
	
	
	public static Receipt createReceipt(Properties p) {
		Receipt receipt = new Receipt();
		String appId = p.getProperty("application.id");
		Application application = new Application(appId);
		String posName = p.getProperty("pos.name");
		String posVersion = p.getProperty("pos.version");
		Pos pos = new Pos(posName, posVersion);
		
		String merchantSMI = p.getProperty("merchant.smi");
		String merchantUsername = p.getProperty("merchant.username");
		String merchantAddress1 = p.getProperty("merchant.address.address1");
		String merchantAddress2 = p.getProperty("merchant.address.address2");
		String merchantAddress3 = p.getProperty("merchant.address.address3");
		String merchantId = p.getProperty("merchant.id");
		String merchantStoreNumber = p.getProperty("merchant.store.number");
		String merchantTelephone = p.getProperty("merchant.telephone");
		String merchantType = p.getProperty("merchant.type");
		
		Merchant merchant = new Merchant(merchantId);
		merchant.setSmi(merchantSMI);
		merchant.setUsername(merchantUsername);
		merchant.setAddress(new Address(merchantAddress1, merchantAddress2, merchantAddress3));
		merchant.setTelephone(merchantTelephone);
		merchant.setStoreNumber(merchantStoreNumber);
		merchant.setType(merchantType);
		
		
		String consumerPEI = p.getProperty("consumer.pei");
		String consumerPIN = p.getProperty("consumer.pin");
		String consumerTEI = p.getProperty("consumer.tei");
		Consumer consumer = new Consumer(consumerPEI, consumerPIN, consumerTEI);
		
		String terminalId = p.getProperty("terminal.id");
		String terminalName = p.getProperty("terminal.name");
		Terminal terminal = new Terminal(terminalId, terminalName);

		String transactionId = p.getProperty("transaction.id");
		Transaction transaction = new Transaction(transactionId);
		transaction.setClosed(new Date() {});
		
		for (int i=0; i<10; i++) {
			String pDescription = "transaction.items." + i + ".description";
			String pInventoryId = "transaction.items." + i + ".inventoryId";
			String pPrice = "transaction.items." + i + ".unitprice";
			String pQuantity = "transaction.items." + i + ".quantity";
			String pCouponId = "transaction.items." + i + ".coupon.id";
			
			String description = p.getProperty(pDescription);
			String inventoryId = p.getProperty(pInventoryId);
			String price = p.getProperty(pPrice);
			String quantity = p.getProperty(pQuantity);
			String couponId = p.getProperty(pCouponId);
			
			if (description != null || inventoryId != null || price != null || quantity != null) {
				Item item = new Item();
				
				item.setDescription(description);
				item.setItemId(inventoryId);
				item.setUnitPrice(Double.valueOf(price));
				item.setQty(Integer.valueOf(quantity));
				
				if (couponId != null) {
					item.setCoupon(new scipio.xml.model.Receipt.Transaction.Items.Item.Coupon(couponId));
				}
				
				//System.out.println("adding item #" + item.getInventoryId() + ": " + item.getQty() + "x " + item.getDescription() + " @ " + item.getUnitPrice() + " each");
				
				transaction.getItems().getItem().add(item);
			}
		}

		int itemsQty = 0;
		BigDecimal itemsSubtotal = new BigDecimal(0.00);
		for (Item item : transaction.getItems().getItem()) {
			itemsQty += item.getQty();
			itemsSubtotal = itemsSubtotal.add(item.getTotal());
		}
		transaction.getItems().setQuantity(itemsQty);
		transaction.getItems().setSubtotal(itemsSubtotal);
		
		for (int i=0; i<10; i++) {
			String pId = "transaction.discounts." + i + ".coupon.id";
			String pName = "transaction.discounts." + i + ".coupon.name";
			String pValue = "transaction.discounts." + i + ".coupon.value";
			String pQuantity = "transaction.discounts." + i + ".coupon.quantity";
					
			String id = p.getProperty(pId);
			String name = p.getProperty(pName);
			String value = p.getProperty(pValue);
			String quantity = p.getProperty(pQuantity);
			
			if (id != null || name != null || value != null) {
				if (quantity == null) {
					quantity = "1";
				}
				
				Coupon coupon = new Coupon(id, name, Double.valueOf(value), Integer.valueOf(quantity));
				coupon.setQuantity(Integer.valueOf(quantity));
				
				transaction.getDiscounts().getCoupons().getCoupon().add(coupon);
			}
		}
		
		int discountsQty = 0;
		BigDecimal discountsSubtotal = new BigDecimal(0.00);
		for (Coupon coupon : transaction.getDiscounts().getCoupons().getCoupon()) {
			discountsQty += coupon.getQuantity();
			discountsSubtotal = discountsSubtotal.add(Util.multiply(coupon.getValue(), coupon.getQuantity()));
		}
		transaction.getDiscounts().setQuantity(discountsQty);
		transaction.getDiscounts().setValue(discountsSubtotal);
		
		//transaction.setSubtotal(transaction.getSubtotal());
		
		String salesTaxRate = p.getProperty("salestax.rate");
		Salestax salestax = new Salestax(Double.valueOf(salesTaxRate));
		salestax.setTaxableAmount(transaction.getSubtotal().subtract(transaction.getDiscount()));
		transaction.setSalestax(salestax);
		
		String tip = p.getProperty("payment.tip");
		transaction.setTip(Double.valueOf(tip));
		
		transaction.setAmountPaid(transaction.getGrandTotal());
		
		String paymentMethod = p.getProperty("payment.method");
		String paymentAmountCharged = p.getProperty("payment.amount");
		String paymentTotal = p.getProperty("payment.total");
		
		String cardType = p.getProperty("payment.card.type");
		String cardNumber = p.getProperty("payment.card.number");
		String cardExp = p.getProperty("payment.card.exp");
		String cardHolder = p.getProperty("payment.card.holder");
		
		Payment payment = new Payment(paymentMethod);
		payment.setCard(new Card(cardType, cardNumber, cardExp, cardHolder));
		payment.setAmountCharged(Double.valueOf(paymentAmountCharged));
		payment.setGrandTotal(Double.valueOf(paymentTotal));
		
		receipt.setApplication(application);
		receipt.setPos(pos);
		receipt.setMerchant(merchant);
		receipt.setTerminal(terminal);
		receipt.setConsumer(consumer);
		receipt.setTransaction(transaction);
		receipt.setPayment(payment);
		
		transaction.setStatus(transaction.getStatus());
		return receipt;
	}
	
}
