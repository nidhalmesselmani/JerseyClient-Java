package demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class Demo extends JFrame implements ActionListener  {
	
	 // JPanel
    JPanel jpanel = new JPanel();
    // Buttons
    JButton auth,getauthUser;
    //Jersey
    Client client ;
    WebTarget target;
    WebTarget target1;
    //Form object
    Form form;
    public Demo() {
   
    	auth = new JButton("click first me to get token");
    	getauthUser = new JButton("click me to get the protected user (you need to put the generated token into the header of the get request first)");
       auth.setBounds(60, 400, 220, 30);
       getauthUser.setBounds(60,400,220,30);
       
       auth.addActionListener(this);
       getauthUser.addActionListener(this);
        // JPanel bounds
        jpanel.setBounds(1200, 1200, 200, 100);

        // Adding to JFrame
        jpanel.add(auth);
        jpanel.add(getauthUser);
        add(jpanel);

        // JFrame properties
        setSize(700, 200);
        setBackground(Color.BLACK);
        setTitle("Air Traffic Control");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       client= ClientBuilder.newClient();
       target= client.target("http://localhost/Lumen_API/public/auth/login");
       target1 =client.target("http://localhost/Lumen_API/public/authuser");
       form = new Form();
       form.param("email", "nidhalmesselmani@yahoo.fr");
       form.param("password", "nKTtzQR7pSut2Lh");

	}
	
	
	public static void main(String[] args){

		new Demo();
	/*	//1st step: create a client 
Client client = ClientBuilder.newClient();
           // we can configure also
	
	//2nd step: set a targets to your clients 
		WebTarget target = client.target("http://localhost/Lumen_API/public/auth/login");
		WebTarget target1 =client.target("http://localhost/Lumen_API/public/authuser");
		//Add key-value pair into the form object
		Form form = new Form();
		form.param("email", "nidhalmesselmani@yahoo.fr");
		form.param("password", "nKTtzQR7pSut2Lh");

		//3rd step: get/post to the server
	/*	System.out.println(
		target1.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0L0x1bWVuX0FQSS9wdWJsaWMvYXV0aC9sb2dpbiIsImlhdCI6MTQ2Njk4MjU0NCwiZXhwIjoxNDY2OTg2MTQ0LCJuYmYiOjE0NjY5ODI1NDQsImp0aSI6IjJhNzFmYjRjNGU2MjRkYTg1NWU1NDZhNWQzYmI1ZWJmIiwic3ViIjozfQ.Y111KKTL-Xczd0-l8wDu74-fpyeS2VWyvRABWDmi7jU").get(String.class));
*/
	//System.out.println(
		
			//target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED)).readEntity(String.class)
	
			//			);
	
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//System.out.println(e.getSource()); 
	
		if(e.getSource()==auth){
			System.out.println(
					
					target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED)).readEntity(String.class)
			
						);
			
			
		}else if(e.getSource()==getauthUser){
			System.out.println(target1.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0L0x1bWVuX0FQSS9wdWJsaWMvYXV0aC9sb2dpbiIsImlhdCI6MTQ2NzAxMTQ3NCwiZXhwIjoxNDY3MDE1MDc0LCJuYmYiOjE0NjcwMTE0NzQsImp0aSI6IjlmYTM4YjkyZGI5NDU0MTk0YzVmYjg0YWU2NjA0NDI5Iiwic3ViIjozfQ.luXffqd2GdVY1fkr3W8Svz0WtBDB1EpQ1-36l4QU0PU").get(String.class));
		}
		
	}

}
