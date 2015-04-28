package App;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JComboBox;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

import View.*;

import com.illposed.osc.*;

public class OSCServer2 extends OSCServer {
	
	//test
	
	private OSCPortIn receiver;
	private OSCListener listener;
	int receiverPort = 8001;
	
	public void launchOSServer() throws java.net.SocketException {
		receiver = new OSCPortIn(receiverPort);
		listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, final OSCMessage message) {
				Float messageArguments = (Float) message.getArguments()[0];

				System.out.println("listener called with address " + 
					message.getAddress() + "; arguments: " + 
					messageArguments);
				
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						try {
							OSCServer.turnLEDOn("6");
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SocketException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						//Page1
						if (messageEquals(message, "/1/push1")) { 
							System.out.println("OSC1 Pressed------");
							if (!Stage1.composite.isDisposed()) {
								Stage1.txtPawsid.setText("mtiger1"); 
								Stage1.txtPassword.setText("********"); 
							}
						}
						if (messageEquals(message, "/1/push2"))
							try {
								Stage1.loginPressed();
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
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						if (messageEquals(message, "/1/push5"))
							try {
								Stage1.loginPressed();
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						//Page 3
						if (messageEquals(message, "/1/push6")) incrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/1/push7")) decrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/1/push8")) incrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/1/push9")) decrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/1/push10")) submitProfile();
						if (messageEquals(message, "/1/push10-"))
							try {
								PostProfileComposite.backButtonPressed();
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						//Page 4
						if (messageEquals(message, "/1/push11")) incrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/1/push12")) decrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/1/push13")) incrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/1/push14")) decrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/1/push15")) incrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/1/push16")) decrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/1/push17")) submitTeam();
						if (messageEquals(message, "/1/push18"))
							try {
								PostTeamComposite.backButtonPressed();
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SocketException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
}