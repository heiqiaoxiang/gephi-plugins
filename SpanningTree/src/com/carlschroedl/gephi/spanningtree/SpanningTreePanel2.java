/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlschroedl.gephi.spanningtree;

import java.util.Collection;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.*;

/**
 *
 * @author carlschroedl
 */
public class SpanningTreePanel2 extends javax.swing.JPanel {
private static final String NOT_FOUND = "No Algorithms Found";
    
    //stui is a link in the chain of communication between front and back end
    // SpanningTreePanel<-->SpanningTreeUI<-->SpanningTree
    private SpanningTreeUI stui;
    
    /** Creates new form SpanningTreePanel */

    public SpanningTreePanel2(SpanningTreeUI stui) {
        
        this.stui=stui;
        
        initComponents();
        
        //Collect all available spanningTreeAlgorithms
        Collection<? extends SpanningTreeAlgorithm> spanningTreeAlgorithms = 
                Lookup.getDefault().lookupAll(SpanningTreeAlgorithm.class);
       
        Vector options;
        boolean empty = spanningTreeAlgorithms.isEmpty();
        if (empty){ 
            options = new Vector();
            options.add(NOT_FOUND);
        }
        else{
            options = new Vector(spanningTreeAlgorithms);
        }
        ComboBoxModel comboModel = new DefaultComboBoxModel(options);
//        algorithmComboBox.setModel(comboModel);
//        propogateAlgorithmChange();
        
        //only enable if options are not empty
//        algorithmComboBox.setEnabled(!empty);              
        
    }

    /** Add here setters and getters for all properties users can edit. */


    
    /** Only useful if the algorithm takes graph type into account. */
    
//    public boolean isDirected() {
//        return directedRadioButton.isSelected();
//    }
//
//    public void setDirected(boolean directed) {
//        directedButtonGroup.setSelected(directed ? directedRadioButton.getModel() : undirectedRadioButton.getModel(), true);
//    }
//
//
//        private void propogateAlgorithmChange(){
//
//        Object selection = algorithmComboBox.getSelectedItem();
//        
//        if(selection instanceof SpanningTreeAlgorithm){
//            stui.setSpanningTreeAlgorithm((SpanningTreeAlgorithm)selection);
//        }
//
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jTextPane1.setText(org.openide.util.NbBundle.getMessage(SpanningTreePanel2.class, "SpanningTreePanel2.jTextPane1.text")); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
