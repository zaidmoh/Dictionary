import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GUI{
	private JFrame mainFrame;
	private JFrame searchFrame;
	private JFrame createFrame;
	//JLabel label;
	JTextField textfield;
	public GUI(){
		mainWindow(); 
		searchWindow();
		createDictionaryWindow();
	}
	public void mainWindow(){
		mainFrame=new JFrame("Dictionary");
		JButton create=new JButton("Create Own Dictionary");
		JButton search=new JButton("Search in Dictionary");
		create.setBounds(70,100,170,40);
		create.addActionListener(new CreateActionListener());
		search.setBounds(350,100,150,40);
		search.addActionListener(new SearchActionListener());
		mainFrame.add(create);
		mainFrame.add(search);
		mainFrame.setSize(600,300);
		mainFrame.setLayout(null);
		//JFrame.setDefaultLookAndFeelDecorated(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	mainFrame.setVisible(true);	
	}
	public void searchWindow(){
		JButton button;
		searchFrame=new JFrame("Search the word");
		JLabel label=new JLabel("");
		textfield=new JTextField();
		button=new JButton("Search");
		searchFrame.add(textfield);
		searchFrame.add(label);
		textfield.setBounds(100,70,200,40);
		button.setBounds(350,70,100,40);
		label.setBounds(100,100,500,40);
		searchFrame.add(textfield);
		searchFrame.add(button);
		searchFrame.setSize(600,300);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.setLayout(null);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String word=textfield.getText();
				word=word.toLowerCase();
				word=word.replaceAll("\\s","");
				//System.out.println(word);
				FileReader f=new FileReader();
				Dictionary d=f.readFile();
				String result=d.search(word);
				if(result.length()==0){
					label.setText("WORD NOT FOUND!");
				}
				else{
					label.setText(result);
				}
				//System.out.println(result);
			}
		});

	}
	public void createDictionaryWindow(){
		Dictionary ownDictionary=new Dictionary();
		createFrame=new JFrame("Create Own Dictionary");
		JTextField wordField=new JTextField(20);
		JTextField meaningField=new JTextField(50);
		JLabel wordLabel=new JLabel("Word");
		JLabel meaningLabel=new JLabel("Meaning");
		JButton addButton=new JButton("Add");
		JButton addAnother=new JButton("Next Word");
		JTextField searchField=new JTextField(20);
		JButton searchWord=new JButton("Search");
		JLabel searchResult=new JLabel("");
		wordLabel.setBounds(100,10,100,30);
		wordField.setBounds(300,10,200,30);
		meaningLabel.setBounds(100,60,100,30);
		meaningField.setBounds(300,60,200,30);
		addButton.setBounds(300,130,80,30);
		addAnother.setBounds(400,130,130,30);
		searchField.setBounds(100,250,200,30);
		searchWord.setBounds(350,250,80,30);
		searchResult.setBounds(100,280,350,30);
		JLabel label=new JLabel("");
		label.setBounds(300,80,500,40);
		createFrame.add(addAnother);
		createFrame.add(label);
		createFrame.add(wordLabel);
		createFrame.add(wordField);
		createFrame.add(meaningLabel);
		createFrame.add(meaningField);
		createFrame.add(addButton);
		createFrame.add(searchField);
		createFrame.add(searchWord);
		createFrame.setSize(600,400);
		createFrame.add(searchResult);
      	createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	createFrame.setLayout(null);
      	addButton.addActionListener(new ActionListener(){
      		public void actionPerformed(ActionEvent e){
      			String word=wordField.getText();
      			String meaning=meaningField.getText();
      			ownDictionary.add(word,meaning);
      			if(word.length()!=0||meaning.length()!=0)
      				label.setText("Added Successfully");
      		}
      	});

      	addAnother.addActionListener(new ActionListener(){
      		public void actionPerformed(ActionEvent e){
      			wordField.setText("");
      			meaningField.setText("");
      			label.setText("");
      		}
      	});

      	searchWord.addActionListener(new ActionListener(){
      		public void actionPerformed(ActionEvent e){
      			String word=searchField.getText();
      			String result=ownDictionary.search(word);
      			searchResult.setText(result);
      		}
      	});
	}
	public static void main(String[] args) {
		new GUI();
	}
	class CustomSearch implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	class CreateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainFrame.setVisible(false);
			createFrame.setVisible(true);
		}
	}
	class SearchActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainFrame.setVisible(false);
			searchFrame.setVisible(true);
		}
	}
}
