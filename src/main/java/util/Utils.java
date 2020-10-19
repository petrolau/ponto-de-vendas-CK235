package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import controller.UsuarioController;
import model.Venda;

public class Utils {

	public static boolean areEmpty(String... args) {
		boolean result = false;
		for (String s : args) {
			result |= (s.isEmpty());
		}
		return result;
	}

	public static void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static void infoMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void gerarRelatorioVendas(List<Venda> vs) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setMultiSelectionEnabled(false);
		jfc.showOpenDialog(null);
		String file = jfc.getSelectedFile().getPath();
		String path = (file + System.getProperty("file.separator") + "Relatorio_" + UsuarioController.getInstance().getLoggedUser() + ".pdf");
		try {
			PdfWriter writer = new PdfWriter(path);
			PdfDocument pdfdoc = new PdfDocument(writer);
			Document d = new Document(pdfdoc);
			Image img = new Image(ImageDataFactory.create(ResourceFinder.getBookImage(), null));
			Paragraph para = new Paragraph();
			para.add(img.scaleToFit(64, 64));
			para.add("Relatório");
			para.setFontSize(32);
			d.add(para);
			float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
			Table tab = new Table(pointColumnWidths);

			String[] tabelas = { "Vendedor", "Produtos", "Data/Hora", "Total" };
			for (String t : tabelas) {
				Cell c = new Cell();
				c.add(t);
				tab.addCell(c);
			}
			double total = 0;
			for (Venda v : vs) {
				Cell c = new Cell();
				c.add(v.getUser().getNome());
				tab.addCell(c);
				c = new Cell();
				c.add(v.getVendido().getNomeProduto());
				tab.addCell(c);
				c = new Cell();
				c.add(v.getDataVenda().toLocaleString());
				tab.addCell(c);
				c = new Cell();
				c.add("R$ " + v.getQtVendido() * v.getVendido().getPreco());
				tab.addCell(c);
				total += v.getQtVendido() * v.getVendido().getPreco();
			}
			
			d.add(tab);
			Paragraph paragrph=new Paragraph();
			paragrph.add("Total: R$  " + Double.toString(total));
			d.add(paragrph);
			d.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Utils.errorMessage("Erro ao gerar o PDF");
			return;
		}
		Utils.infoMessage("Arquivo gerado com sucesso");
	}

}
