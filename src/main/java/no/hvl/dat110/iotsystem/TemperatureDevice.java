package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		System.out.println("Display starting ...");

		// create a client object and use it to

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		
		client.connect();
		//client.createTopic("temperature");
		//client.subscribe("temperature");
		int i = 0;
		while (i < COUNT) {
			client.publish(Common.TEMPTOPIC, sn.read() + "");
			i++;
		}
		//client.unsubscribe("temperature");
		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");

		

	}
}
