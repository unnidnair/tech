package com.concept.features;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample {

	Exchanger<String> exchanger = new Exchanger<String>();

	private void start() {
		new Thread(() -> {
			try {
				for (int index = 0; index < 10; index++) {
					exchanger.exchange("Ready Queue " + index);
					TimeUnit.SECONDS.sleep(1);
				}
				exchanger.exchange("EXIT");
			} catch (Exception e) {
			}
		}).start();

		new Thread(r, "Consumer").start();
		new Thread(r, "Consumer1").start();
	}

	Runnable r = () -> {
		try {
			while (true) {
				String queue = exchanger.exchange("received");
				if (queue.equals("EXIT")) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + " now has " + queue);
			}
		} catch (InterruptedException e) {
		}
	};

	public static void main(String[] args) {
		new ExchangerExample().start();
	}

}
