package com.github.ZXSkelobrine.barcode;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

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

	public static void calculate(List<Product> p1, List<Product> p2) {
		double d1 = p1.size() / 31;
		double d2 = p2.size() / 31;
		System.out.println("P1: " + p1.size() + "\nMod: " + d1 + "\n");
		System.out.println("P2: " + p2.size() + "\nMod: " + d2 + "\n");
	}

	public static void doublePrint(List<Product> p1, List<Product> p2) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printer());
		boolean doPrint = job.printDialog();
		if (doPrint) {
			try {
				if (p1.size() > 36) {
					List<Product> p11 = new ArrayList<>();
					List<Product> p12 = new ArrayList<>();
					for (int i = 0; i < 31; i++) {
						p11.add(p1.get(i));
					}
					for (int i = 31; i < p1.size(); i++) {
						p12.add(p1.get(i));
					}
					Printer.setTitle("Owned Stock Summary");
					printArrays(job, p11, p12);
				} else {
					Printer.setTitle("Owned Stock Summary");
					printArrays(job, p1);
				}
				if (p2.size() > 36) {
					List<Product> p21 = new ArrayList<>();
					List<Product> p22 = new ArrayList<>();
					for (int i = 0; i < 31; i++) {
						p21.add(p2.get(i));
					}
					for (int i = 31; i < p2.size(); i++) {
						p22.add(p2.get(i));
					}
					Printer.setTitle("Needed Stock Summary");
					printArrays(job, p21, p22);
				} else {
					Printer.setTitle("Needed Stock Summary");
					printArrays(job, p2);
				}
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

	@SafeVarargs
	private static void printArrays(PrinterJob job, List<Product>... lists) throws PrinterException {
		for (List<Product> products : lists) {
			Printer.setProducts(products);
			job.print();
			Printer.reset();
		}
	}

}
