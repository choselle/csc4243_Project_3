package App;

import java.net.SocketException;
import java.net.UnknownHostException;

import View.LoginView;
import View.Stage1;

public class Application {

	public Application() throws SocketException, UnknownHostException {

		OSCServer osc = new OSCServer();
		OSCServer2 osc2 = new OSCServer2();
		osc.launchOSServer();
		osc2.launchOSServer();
		Stage1 stage = new Stage1();
		stage.open();
	}

	public static void main(String args[]) throws SocketException, UnknownHostException {

		Application app = new Application();
	}
}
