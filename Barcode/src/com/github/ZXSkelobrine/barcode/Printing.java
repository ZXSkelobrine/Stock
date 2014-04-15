package com.github.ZXSkelobrine.barcode;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Printing {

	public static void print() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printer());
		boolean doPrint = job.printDialog();
		if (doPrint) {
			try {
				job.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

}
