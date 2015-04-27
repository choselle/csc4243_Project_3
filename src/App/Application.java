package App;

import java.net.SocketException;
<<<<<<< HEAD
import java.net.UnknownHostException;
=======
>>>>>>> 01a6d8dcc0e82a35b067978db99920726215b1ac

import View.LoginView;
import View.Stage1;

public class Application {

<<<<<<< HEAD
	public Application() throws SocketException, UnknownHostException {
=======
	public Application() throws SocketException {
>>>>>>> 01a6d8dcc0e82a35b067978db99920726215b1ac

		OSCServer osc = new OSCServer();
		OSCServer2 osc2 = new OSCServer2();
		osc.launchOSServer();
		osc2.launchOSServer();
		Stage1 stage = new Stage1();
		stage.open();
	}

<<<<<<< HEAD
	public static void main(String args[]) throws SocketException, UnknownHostException {
=======
	public static void main(String args[]) throws SocketException {
>>>>>>> 01a6d8dcc0e82a35b067978db99920726215b1ac

		Application app = new Application();
	}
}
