import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame
        extends JFrame
        implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel price;
    private JTextField tprice;
    private JLabel gender;
    private JRadioButton sugar;
    private JRadioButton sugarfree;
    private ButtonGroup gengp;
    private JLabel sm;
    private JComboBox material;
    private JComboBox size;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    private String materials[]
            = { "metal","plastic","glass" };
    private String capacity[]
            = { "250ml","500ml","1000ml","1500ml" };

    public MyFrame()
    {
        setTitle("Energy Drink Factory");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Energy Drink Factory");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        price = new JLabel("Price");
        price.setFont(new Font("Arial", Font.PLAIN, 20));
        price.setSize(100, 20);
        price.setLocation(100, 150);
        c.add(price);

        tprice = new JTextField();
        tprice.setFont(new Font("Arial", Font.PLAIN, 15));
        tprice.setSize(150, 20);
        tprice.setLocation(200, 150);
        c.add(tprice);

        gender = new JLabel("Content");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        sugar = new JRadioButton("Sugar");
        sugar.setFont(new Font("Arial", Font.PLAIN, 15));
        sugar.setSelected(true);
        sugar.setSize(80, 20);
        sugar.setLocation(200, 200);
        c.add(sugar);

        sugarfree = new JRadioButton("Sugarfree");
        sugarfree.setFont(new Font("Arial", Font.PLAIN, 15));
        sugarfree.setSelected(false);
        sugarfree.setSize(100, 20);
        sugarfree.setLocation(275, 200);
        c.add(sugarfree);

        gengp = new ButtonGroup();
        gengp.add(sugar);
        gengp.add(sugarfree);

        sm = new JLabel("Packaging");
        sm.setFont(new Font("Arial", Font.PLAIN, 20));
        sm.setSize(80, 20);
        sm.setLocation(100, 250);
        c.add(sm);

        material = new JComboBox(materials);
        material.setFont(new Font("Arial", Font.PLAIN, 15));
        material.setSize(80, 20);
        material.setLocation(200, 250);
        c.add(material);

        size = new JComboBox(capacity);
        size.setFont(new Font("Arial", Font.PLAIN, 15));
        size.setSize(60, 20);
        size.setLocation(250, 250);
        c.add(size);


        add = new JLabel("Id");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Save configuration");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data
                        = "Name : "
                        + tname.getText() + "\n"
                        + "Price : "
                        + tprice.getText() + "\n";
                if (sugar.isSelected())
                    data1 = "Content: With sugar"
                            + "\n";
                else
                    data1 = "Content: Sugarfree"
                            + "\n";
                String data2
                        = "Material, size : "
                        + (String)material.getSelectedItem()
                        + "/" + (String)size.getSelectedItem()
                        + "\n";

                String data3 = "Id : " + tadd.getText();
                tout.setText(data + data1 + data2 + data3);
                tout.setEditable(false);
                res.setText("Configuration saved");
            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please save the"
                        + " configuration");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tprice.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            material.setSelectedIndex(0);
            size.setSelectedIndex(0);
            resadd.setText(def);
        }
        System.out.println("Final product:");
        System.out.println("name: " + tname.getText());
        System.out.println("price: " + tprice.getText());
        System.out.println("material: " + material.getSelectedItem());
        System.out.println("size: " + size.getSelectedItem());
        System.out.println("material: " + material.getSelectedItem());
        System.out.println("id: " + tadd.getText());
    }
}
