//-AE-

package com.floreantpos.ui.dialog;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

import com.floreantpos.PosException;
import com.floreantpos.main.Application;
//import com.floreantpos.model.ScipioInfo;
import com.floreantpos.model.Ticket;
//import com.floreantpos.model.dao.ScipioInfoDAO;

/**
 *
 * @author Aaron Evans <aarone@one-shore.com>
 */
public class ScipioDialog extends POSDialog {

	private Ticket ticket;
	//private ScipioInfo scipio;
			
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.floreantpos.swing.PosButton btnCancel;
    private com.floreantpos.swing.PosButton btnOk;
    private javax.swing.JLabel lblPEI;
    private javax.swing.JLabel lblPIN;
    private javax.swing.JLabel lblTEI;
    private com.floreantpos.ui.TitlePanel titlePanel1;
    private javax.swing.JFormattedTextField txtPEI;
    private javax.swing.JFormattedTextField txtPIN;
    private javax.swing.JFormattedTextField txtTEI;
    // End of variables declaration//GEN-END:variables
	
    MaskFormatter teiFormatter = null;
	MaskFormatter pinFormatter = null;
	MaskFormatter peiFormatter = null;
	
	
	
	/**
	 * Creates new form ScipioDialog
	 */
	public ScipioDialog() {
		super(Application.getPosWindow(), true, false);
		
		System.out.println("in ScipioDialog constructor");
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
        try {
			teiFormatter = new MaskFormatter("#####");
			pinFormatter = new MaskFormatter("####");
			peiFormatter = new MaskFormatter("######");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		initComponents();
		setResizable(false);
        pack();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel1 = new com.floreantpos.ui.TitlePanel();
        lblTEI = new javax.swing.JLabel();
        btnOk = new com.floreantpos.swing.PosButton();
        btnCancel = new com.floreantpos.swing.PosButton();
        txtTEI = new javax.swing.JFormattedTextField();
        lblPIN = new javax.swing.JLabel();
        txtPIN = new javax.swing.JFormattedTextField();
        lblPEI = new javax.swing.JLabel();
        txtPEI = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SCIPIO INFORMATION");

        titlePanel1.setTitle("SCIPIO INFORMATION");

        lblTEI.setText("TEI:");
        lblTEI.setMaximumSize(new java.awt.Dimension(32, 16));
        lblTEI.setMinimumSize(new java.awt.Dimension(16, 16));
        lblTEI.setPreferredSize(new java.awt.Dimension(32, 16));

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finish_32.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkdoOk(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png"))); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceldoCancel(evt);
            }
        });

        txtTEI.setText("12345");
        txtTEI.setMaximumSize(new java.awt.Dimension(250, 30));
        txtTEI.setMinimumSize(new java.awt.Dimension(24, 20));

        lblPIN.setText("PIN:");
        lblPIN.setMaximumSize(new java.awt.Dimension(32, 16));
        lblPIN.setMinimumSize(new java.awt.Dimension(16, 16));
        lblPIN.setPreferredSize(new java.awt.Dimension(32, 16));

        txtPIN.setText("1234");
        txtPIN.setMaximumSize(new java.awt.Dimension(250, 30));
        txtPIN.setMinimumSize(new java.awt.Dimension(24, 20));
        txtPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPINActionPerformed(evt);
            }
        });

        lblPEI.setText("PEI:");
        lblPEI.setMaximumSize(new java.awt.Dimension(32, 16));
        lblPEI.setMinimumSize(new java.awt.Dimension(16, 16));
        lblPEI.setPreferredSize(new java.awt.Dimension(32, 16));

        txtPEI.setText("123456");
        txtPEI.setMaximumSize(new java.awt.Dimension(250, 30));
        txtPEI.setMinimumSize(new java.awt.Dimension(24, 20));
        txtPEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPEIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPEI, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPIN, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTEI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPEI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPEI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTEI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtTEI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void initData() throws Exception {
		System.out.println("...in ScipioDialog.initData()");
		System.out.println("ticket: " + ticket.getId());
		
//		ScipioInfoDAO dao = new ScipioInfoDAO();
//		dao.createNewSession();
//		
//		try {
//			System.out.println("looking for scipioInfo for ticket");
//			scipio = dao.getScipioInfo(ticket);
//		} 
//		catch (Exception e) {
//			System.out.println("scipioInfo not found for ticket");
//			scipio = new ScipioInfo();
//			//e.printStackTrace();
//		}
//
//		System.out.println(scipio);
		
	}

	// temporarily added to workaround Netbeans dialog code generation
	// TODO: edit to just use doOk
	private void btnOkdoOk(java.awt.event.ActionEvent evt) {
		doOk(evt);
	}
	private void doOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkdoOk
		try {
			System.out.println("...in ScipioDialog.doOk()");
			/*
			if (scipio == null) {
				System.out.println("scipio is null... creating new ScipioInfo object");
				scipio = new ScipioInfo();
			}
			
			try {
				scipio.setTEI(txtTEI.getText());
				scipio.setPEI(txtPEI.getText());
				scipio.setPIN(txtPIN.getText());
				scipio.setTicket(ticket);
				
//				ScipioInfoDAO dao = ScipioInfoDAO.getInstance();
//				dao.createNewSession();
//				dao.save(scipio);
			}
			catch (Exception e) {
				e.printStackTrace();
				
				throw new PosException("Scipio info is not valid.\n" + e.getMessage());	
			}
				
			setCanceled(false);
			dispose();
                        * 
                        */
		} catch (PosException e) {
			POSMessageDialog.showError(this, e.getMessage());
		}
	}//GEN-LAST:event_btnOkdoOk

	// temporarily added to workaround Netbeans dialog code generation
	// TODO: edit to just use doCancel
	private void btnCanceldoCancel(java.awt.event.ActionEvent evt) {
		doCancel(evt);
	}
	private void doCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceldoCancel
		System.out.println("... inScipioDialog.doCancel()");
		setCanceled(true);
		dispose();
	}//GEN-LAST:event_btnCanceldoCancel

	private void txtPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPINActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtPINActionPerformed

	private void txtPEIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPEIActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtPEIActionPerformed


	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	/*
	public ScipioInfo getScipioInfo() {
		return scipio;
	}
        * 
        */
}