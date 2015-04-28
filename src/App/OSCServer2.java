package App;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JComboBox;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import View.*;

import com.illposed.osc.*;

public class OSCServer2 extends OSCServer {
	
	//test
	
	private OSCPortIn receiver;
	private OSCListener listener;
	protected static OSCPortOut sender;
	int receiverPort = 8001;
	
	public void launchOSServer() throws java.net.SocketException, UnknownHostException {
		receiver = new OSCPortIn(receiverPort);
		sender = new OSCPortOut(InetAddress.getByName("192.168.1.117"), 9001);
		listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, final OSCMessage message) {
				Float messageArguments = (Float) message.getArguments()[0];

				System.out.println("listener called with address " + 
					message.getAddress() + "; arguments: " + 
					messageArguments);
				
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						//Page1
						if (messageEquals(message, "/1/push1")) { 
							System.out.println("OSC1 Pressed------");
							if (!Stage1.composite.isDisposed()) {
								Stage1.txtPawsid.setText("sbear2"); 
								Stage1.txtPassword.setText("********"); 
							}
						}
						if (messageEquals(message, "/1/push2"))
							try {
								turnLEDOff();
								turnLEDOn("2");
								LoginConnected(1);
								Stage1.loginPressed();
								ProfileViewComposite.lblProfilePic.setImage(SWTResourceManager.getImage(ProfileViewComposite.class, "/images/smokeythebear.png"));
								ProfileViewComposite.tltmWelcomeMike.setText("Welcome, Smokey!");
								ProfileViewComposite.lblNewLabel_1.setText("Smokey the Bear");
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						//Page 2
						if (messageEquals(message, "/1/push3"))
							try {
								ProfileViewComposite.PostProfilePressed();
								turnLEDOff();
								turnLEDOn("3");
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						if (messageEquals(message, "/1/push4"))
							try {
								ProfileViewComposite.PostTeamPressed();
								turnLEDOff();
								turnLEDOn("4");
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						//Page 3
						if (messageEquals(message, "/1/push5")) incrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/1/push6")) decrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/1/push7")) incrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/1/push8")) decrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/1/push9")) submitProfile();
						//Page 4
						if (messageEquals(message, "/1/push10")) incrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/1/push11")) decrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/1/push12")) incrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/1/push13")) decrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/1/push14")) incrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/1/push15")) decrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/1/push16")) submitTeam();
						if (messageEquals(message, "/1/push17")) {
							try {
								turnLEDOff();
								turnLEDOn("1");
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(ProfileViewComposite.ptc != null)
								ProfileViewComposite.ptc.setVisible(false);
							if(ProfileViewComposite.ppc != null)
								ProfileViewComposite.ppc.setVisible(false);
							if(Stage1.pvc != null)
								Stage1.pvc.setVisible(false);
							if(Stage1.composite != null)
								Stage1.composite.setVisible(true);
							try {
								LoginConnected(0);
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
					}
				});			
			}
		};
		
		
		
		//Add all the components to the listener.
		String[] componentArray = {"/1/push1", "/1/push2", "/1/push3", "/1/push4", "/1/push5", "/1/push6", "/1/push7", "/1/push8", "/1/push9", "/1/push10", 
				"/1/push11", "/1/push12", "/1/push13", "/1/push14", "/1/push15", "/1/push16", "/1/push17", "/1/push18", };
		for (String comp : componentArray) {
			receiver.addListener(comp, listener);
		}

		System.out.println("Server is listening on port " + receiverPort);
		receiver.startListening();
	}
	
	public static void turnLEDOn(String led) throws UnknownHostException, SocketException {
		Object args[] = new Object[1];
		args[0] = new Float(1.0);
		OSCMessage msg = new OSCMessage("/1/led"+led, args);
		try {
			sender.send(msg);
			System.out.println("sender called with address " + 
					msg.getAddress() + "; arguments: " + 
					(Float) msg.getArguments()[0]);
		} catch (Exception e) {
			System.out.println("Could not send");
		}
	}
	
	//turns all LED lights off in the TouchOSC interface
	public static void turnLEDOff() throws UnknownHostException, SocketException {
		Object args[] = new Object[1];
		args[0] = new Float(0.0);
		OSCMessage msg1 = new OSCMessage("/1/led1", args);
		OSCMessage msg2 = new OSCMessage("/1/led2", args);
		OSCMessage msg3 = new OSCMessage("/1/led3", args);
		OSCMessage msg4 = new OSCMessage("/1/led4", args);
		try {
			sender.send(msg1);
			sender.send(msg2);
			sender.send(msg3);
			sender.send(msg4);
		} catch (Exception e) {
			System.out.println("Could not send");
		}
	}
	
	public void LoginConnected(int i) throws UnknownHostException, SocketException {
		Object args[] = new Object[1];
		if (i == 1)
			args[0] = new Float(1.0);
		else
			args[0] = new Float(0.0);
		OSCMessage msg = new OSCMessage("/1/led6", args);
		try {
			sender.send(msg);
			System.out.println("sender called with address " + 
					msg.getAddress() + "; arguments: " + 
					(Float) msg.getArguments()[0]);
		} catch (Exception e) {
			System.out.println("Could not send");
		}
	}

}