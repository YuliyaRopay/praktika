package day8.HwBirds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.List;


public class BirdsStoreUI {

    private BirdsStore store;
    //private List<Customer> customerList;

    public BirdsStoreUI(BirdsStore store){
        this.store=store;

        JFrame frame=new JFrame();
        frame.setMinimumSize(new Dimension(600,400));
        frame.setLocation(150,150);

        frame.getContentPane().add(createSellingPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createSellingPanel(){
        JPanel mainPanel =new JPanel();
        mainPanel.setLayout(new GridBagLayout());


        //
        JLabel labelCustomer=new JLabel("Customer name: ");
       // JComboBox comboBoxCustomer=new JComboBox(store.getCustomerList().toArray());

        Object[] customerList=store.getCustomerList().toArray();
        final JComboBox comboBoxCustomer=new JComboBox(customerList);

        mainPanel.add(labelCustomer,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        mainPanel.add(comboBoxCustomer,new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));


        //
        JLabel labelBirds=new JLabel("Birds: ");
        final JPanel cards =new JPanel(new CardLayout());
        final ButtonGroup birdsGroup=new ButtonGroup();
        JPanel birdsPanel = new JPanel();

        String[] comboBoxItems=store.getBirdsTypeArray();

        JComboBox comboBoxBirds = new JComboBox(comboBoxItems);
        comboBoxBirds.setEditable(false);
        comboBoxBirds.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
            }
        });

        birdsPanel.add(comboBoxBirds);

        for(String item:comboBoxItems){
            JPanel card = new JPanel();
            List<Bird> birdsByTypeList=store.getBirdsByTypeList(item);
            int listSize=0;
            if(birdsByTypeList!=null){
                listSize=birdsByTypeList.size();
            }
            card.setLayout(new GridLayout(listSize+1, 0));
            for(Bird bird: birdsByTypeList){
                JRadioButton rButton=new JRadioButton(bird.toString());
                rButton.setActionCommand(bird.getName());
                birdsGroup.add(rButton);
                card.add(rButton);
            }

            cards.add(card,item);
        }

        mainPanel.add(labelBirds,new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        mainPanel.add(birdsPanel,new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        mainPanel.add(cards,new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));


        //
        JLabel labelCount=new JLabel("Count: ");
        NumberFormat nf=NumberFormat.getNumberInstance();
        final JFormattedTextField tfCount=new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);
        mainPanel.add(labelCount, new GridBagConstraints(0,3,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        mainPanel.add(tfCount, new GridBagConstraints(1,3,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));


        //
        JButton btnBuy=new JButton("Buy");
        mainPanel.add(btnBuy, new GridBagConstraints(1,4,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));


        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer=(Customer)comboBoxCustomer.getSelectedItem();
                int count=Integer.parseInt(tfCount.getText());
                String strBird=birdsGroup.getSelection().getActionCommand();

                store.soldBirds(customer,strBird,count);
                System.out.println(strBird);

            }
        });


        return mainPanel;
    }


    ///////////////////
    private JPanel createSellingPanel2(){
        JPanel panel =new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel lName=new JLabel("Customer name:");
        final JTextField tfName= new JTextField();
        tfName.setColumns(25);

        panel.add(lName, new GridBagConstraints(0,0,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        panel.add(tfName, new GridBagConstraints(1,0,1,1,0,0, GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));


        //
        JLabel lBirds=new JLabel("Birds:");
        List<Bird> birdsList=store.getBirdsList();

        final ButtonGroup birdsGroup=new ButtonGroup();
        final JPanel pBirds=new JPanel();
        pBirds.setLayout(new GridLayout(birdsList.size(),0));
        pBirds.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        //ActionListener rbListener=new RBListener();

        for(Bird bird:birdsList){
            JRadioButton rButton=new JRadioButton(bird.getName());
            rButton.setActionCommand(bird.getName());
            birdsGroup.add(rButton);
            pBirds.add(rButton);
        }

        panel.add(lBirds, new GridBagConstraints(0,1,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        panel.add(pBirds, new GridBagConstraints(1,1,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));

        //
        JLabel lCount=new JLabel("Count:");
        NumberFormat nf=NumberFormat.getNumberInstance();
        final JFormattedTextField tfCount=new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);
        panel.add(lCount, new GridBagConstraints(0,2,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));
        panel.add(tfCount, new GridBagConstraints(1,2,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));

        JButton btnBuy=new JButton("Buy");
        panel.add(btnBuy, new GridBagConstraints(1,3,1,1,0,0, GridBagConstraints.LINE_START,0,new Insets(0,0,0,0),0,0));


        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer=new Customer("l1",tfName.getText());
                int count=Integer.parseInt(tfCount.getText());
                String strBird=birdsGroup.getSelection().getActionCommand();
                store.soldBirds(customer,strBird,count);
                //System.out.println(store.getTransactionList().get());
            }
        });

        return panel;
    }
}
