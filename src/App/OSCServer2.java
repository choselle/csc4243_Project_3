package App;
import javax.swing.JComboBox;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

import View.*;

import com.illposed.osc.*;

public class OSCServer2 {
	
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
						//Page1
						if (messageEquals(message, "/1/push1")) { 
							System.out.println("OSC2 Pressed------");
						}
					}
				});			
			}
		};
		
		//Add all the components to the listener.
		String[] componentArray = {"/1/push1"};
		for (String comp : componentArray) {
			receiver.addListener(comp, listener);
		}

		System.out.println("Server is listening on port " + receiverPort);
		receiver.startListening();
	}
	
	//checks to see if the message is equal to the conditional string
		public boolean messageEquals(OSCMessage message, String str) {
			Float messageArguments = (Float) message.getArguments()[0];
			
			if (message.getAddress().equals(str) && messageArguments == 1.0)
				return true;
			else
				return false;
		}
}