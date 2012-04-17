/*
 * VoidTicketDialog.java
 *
 * Created on September 2, 2006, 11:52 PM
 */

package com.floreantpos.ui.dialog;


import java.awt.Frame;
import java.util.List;

import com.floreantpos.POSConstants;
import com.floreantpos.main.Application;
import com.floreantpos.model.ActionHistory;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.VoidReason;
import com.floreantpos.model.dao.ActionHistoryDAO;
import com.floreantpos.model.dao.TicketDAO;
import com.floreantpos.model.dao.VoidReasonDAO;
import com.floreantpos.print.PosPrintService;
import com.floreantpos.swing.ListComboBoxModel;

/**
 *
 * @author  MShahriar
 */
public class VoidTicketDialog extends POSDialog {
    private Ticket ticket;
    
    /** Creates new form VoidTicketDialog */
    public VoidTicketDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal, true);
        initComponents();
        
        ticketDetailView.setButtonPanelVisible(false);
        
        try {
			VoidReasonDAO dao = new VoidReasonDAO();
			List<VoidReason> voidReasons = dao.findAll();
			cbVoidReasons.setModel(new ListComboBoxModel(voidReasons));
		} catch (Exception e) {
			POSMessageDialog.showError(com.floreantpos.POSConstants.CANNOT_LOAD_VOID_REASONS, e);
		}
		
		setSize(794, 575);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new com.floreantpos.swing.TransparentPanel();
        titlePanel1 = new com.floreantpos.ui.TitlePanel();
        transparentPanel1 = new com.floreantpos.swing.TransparentPanel();
        jPanel1 = new javax.swing.JPanel();
        ticketView = new com.floreantpos.ui.views.order.TicketView();
        jPanel2 = new javax.swing.JPanel();
        ticketDetailView = new com.floreantpos.ui.views.TicketDetailView();
        transparentPanel2 = new com.floreantpos.swing.TransparentPanel();
        cbVoidReasons = new javax.swing.JComboBox();
        btnNewVoidReason = new com.floreantpos.swing.PosButton();
        chkItemsWasted = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        transparentPanel3 = new com.floreantpos.swing.TransparentPanel();
        transparentPanel4 = new com.floreantpos.swing.TransparentPanel();
        btnVoid = new com.floreantpos.swing.PosButton();
        btnCancel = new com.floreantpos.swing.PosButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        contentPane.setLayout(new java.awt.BorderLayout());

        titlePanel1.setPreferredSize(new java.awt.Dimension(400, 60));
        titlePanel1.setTitle(com.floreantpos.POSConstants.VOID_TICKET);
        contentPane.add(titlePanel1, java.awt.BorderLayout.NORTH);

        transparentPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        ticketView.setControlsVisible(false);
        jPanel1.add(ticketView, java.awt.BorderLayout.CENTER);

        transparentPanel1.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        ticketDetailView.setBalanceDuePanelVisible(false);
        jPanel2.add(ticketDetailView, java.awt.BorderLayout.CENTER);

        transparentPanel2.setPreferredSize(new java.awt.Dimension(0, 80));

        btnNewVoidReason.setText("...");
        btnNewVoidReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewVoidReasonActionPerformed(evt);
            }
        });

        chkItemsWasted.setText(com.floreantpos.POSConstants.ITEMS_WASTED);
        chkItemsWasted.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkItemsWasted.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel1.setText(com.floreantpos.POSConstants.VOID_REASON + ":");

        org.jdesktop.layout.GroupLayout transparentPanel2Layout = new org.jdesktop.layout.GroupLayout(transparentPanel2);
        transparentPanel2.setLayout(transparentPanel2Layout);
        transparentPanel2Layout.setHorizontalGroup(
            transparentPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(transparentPanel2Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(transparentPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkItemsWasted)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, transparentPanel2Layout.createSequentialGroup()
                        .add(cbVoidReasons, 0, 0, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnNewVoidReason, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        transparentPanel2Layout.setVerticalGroup(
            transparentPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(transparentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(transparentPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, transparentPanel2Layout.createSequentialGroup()
                        .add(transparentPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(cbVoidReasons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(chkItemsWasted)
                        .add(34, 34, 34))
                    .add(transparentPanel2Layout.createSequentialGroup()
                        .add(btnNewVoidReason, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(53, 53, 53))))
        );

        jPanel2.add(transparentPanel2, java.awt.BorderLayout.SOUTH);

        transparentPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        contentPane.add(transparentPanel1, java.awt.BorderLayout.CENTER);

        transparentPanel3.setLayout(new java.awt.BorderLayout());

        btnVoid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/void_ticket_32.png"))); // NOI18N
        btnVoid.setText(com.floreantpos.POSConstants.VOID);
        btnVoid.setPreferredSize(new java.awt.Dimension(140, 60));
        btnVoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoidActionPerformed(evt);
            }
        });
        transparentPanel4.add(btnVoid);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png"))); // NOI18N
        btnCancel.setText(com.floreantpos.POSConstants.CANCEL);
        btnCancel.setPreferredSize(new java.awt.Dimension(140, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        transparentPanel4.add(btnCancel);

        transparentPanel3.add(transparentPanel4, java.awt.BorderLayout.CENTER);
        transparentPanel3.add(jSeparator1, java.awt.BorderLayout.NORTH);

        contentPane.add(transparentPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(contentPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewVoidReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewVoidReasonActionPerformed
    	try {
			NotesDialog dialog = new NotesDialog((Frame) getOwner(), true);
			dialog.setTitle(com.floreantpos.POSConstants.ENTER_VOID_REASON);
			dialog.pack();
			dialog.open();

			if (!dialog.isCanceled()) {
				String newVoidReason = dialog.getNote();
				VoidReason voidReason = new VoidReason();
				voidReason.setReasonText(newVoidReason);

				VoidReasonDAO dao = new VoidReasonDAO();
				dao.save(voidReason);
				
				if(cbVoidReasons.getModel() instanceof ListComboBoxModel) {
					ListComboBoxModel model = (ListComboBoxModel) cbVoidReasons.getModel();
					model.addElement(voidReason);
				}
			}
		} catch (Throwable e) {
			POSMessageDialog.showError(POSConstants.ERROR_MESSAGE, e);
		}
    }//GEN-LAST:event_btnNewVoidReasonActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    	canceled = true;
    	dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnVoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoidActionPerformed
    	try {
			VoidReason voidReason = (VoidReason) cbVoidReasons.getSelectedItem();
			if(voidReason != null) {
				ticket.setVoidReason(voidReason.getReasonText());
			}
			ticket.setWasted(chkItemsWasted.isSelected());
			ticket.setVoidedBy(Application.getCurrentUser());
			
			TicketDAO dao = new TicketDAO();
			dao.voidTicket(ticket);
			
			try {
				PosPrintService.printVoidInfo(ticket);
			}catch(Exception ee) {
				String message = "There was an error while printing void information to kitchen\n" + ee.getMessage();
				POSMessageDialog.showError(Application.getPosWindow(), message, ee);
			}
			
			canceled = false;
			
			//save the action
			ActionHistoryDAO.getInstance().saveHistory(Application.getCurrentUser(), ActionHistory.VOID_CHECK, com.floreantpos.POSConstants.CHK_NO + ":"+ticket.getId() +"; Total" + ": " + Application.formatNumber(ticket.getTotalAmount()));
			
			dispose();
		} catch (Exception e) {
			POSMessageDialog.showError(POSConstants.ERROR_MESSAGE, e);
		}
    }//GEN-LAST:event_btnVoidActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.floreantpos.swing.PosButton btnCancel;
    private com.floreantpos.swing.PosButton btnNewVoidReason;
    private com.floreantpos.swing.PosButton btnVoid;
    private javax.swing.JComboBox cbVoidReasons;
    private javax.swing.JCheckBox chkItemsWasted;
    private com.floreantpos.swing.TransparentPanel contentPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private com.floreantpos.ui.views.TicketDetailView ticketDetailView;
    private com.floreantpos.ui.views.order.TicketView ticketView;
    private com.floreantpos.ui.TitlePanel titlePanel1;
    private com.floreantpos.swing.TransparentPanel transparentPanel1;
    private com.floreantpos.swing.TransparentPanel transparentPanel2;
    private com.floreantpos.swing.TransparentPanel transparentPanel3;
    private com.floreantpos.swing.TransparentPanel transparentPanel4;
    // End of variables declaration//GEN-END:variables

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
		
		ticketView.setTicket(ticket);
		ticketDetailView.setTicket(ticket);
	}
    
}
