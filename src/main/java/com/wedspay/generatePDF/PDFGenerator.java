package com.wedspay.generatePDF;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.wedspay.entity.Payment;

public class PDFGenerator {

	private String girlName;
	private String boyName;
	private String marriageDate;
	private List<Payment> payments;

	public PDFGenerator(List<Payment> payments) {
		this.payments = payments;
	}
	
	public void generate(HttpServletResponse response) throws DocumentException, IOException{
		
		Document doc = new Document(PageSize.A4);
		
		// PDF writer instance
		PdfWriter.getInstance(doc, response.getOutputStream());
		
		doc.open();
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(25);
		
		// let create paragraph.
		Paragraph paragraph = new Paragraph("WedsPay", fontTitle);
		paragraph.setAlignment(paragraph.ALIGN_LEFT);
		paragraph.setSpacingAfter(5);
		doc.add(paragraph);
		fontTitle.setSize(11);
		String line = boyName.toUpperCase()+" WEDS "+girlName.toUpperCase();
		paragraph = new Paragraph(line, fontTitle);
		doc.add(paragraph);
		line = "DATE : "+marriageDate;
		paragraph = new Paragraph(line, fontTitle);
		paragraph.setSpacingAfter(8);
		doc.add(paragraph);
		fontTitle.setSize(20);
		paragraph = new Paragraph("Shagun Received List", fontTitle);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);
		paragraph.setSpacingAfter(8);
		doc.add(paragraph);
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3, 6, 2});
		table.setSpacingAfter(5);
		
		// cell creating.
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);
		
		// now putting heading in PDF.
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Address", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);
		
		
		// now putting our main data of payment in PDF.
		for(Payment p : payments) {
			// name adding
			table.addCell(p.getName());
			// address adding
			table.addCell(p.getAddress());
			// adding Amount.
			table.addCell(String.valueOf(p.getAmount()));
		}
		
		doc.add(table);
		
		doc.close();
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

	public String getBoyName() {
		return boyName;
	}

	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}

	public String getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(String marriageDate) {
		this.marriageDate = marriageDate;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}







