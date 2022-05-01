package energy.escritadocx;

import energy.model.Cliente;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NovoCliente {

    /*public void registarCredenciaisCliente(Cliente cliente, String a){

        FileOutputStream fileOutputStream = null;
        XWPFDocument document = new XWPFDocument();

        try {

            fileOutputStream = new FileOutputStream(new File("src\\arquivosdocx\\registodedadosecredenciais\\" +
                    "cliente\\Confirmação"+ cliente.getNome() +".docx"));

            XWPFParagraph xwpfParagafo1 = document.createParagraph();
            XWPFRun xwpfRun1 = xwpfParagafo1.createRun();

            xwpfRun1.setText("COMPROVATIVO DE REGISTO DE DADOS");
            xwpfRun1.setBold(true);
            xwpfRun1.addBreak();
            xwpfRun1.addBreak();

            XWPFParagraph xwpfParagrafo2 = document.createParagraph();
            XWPFRun xwpfRun2 = xwpfParagrafo2.createRun();
            xwpfRun2.setText("O cliente " + cliente.getNome() + " " +cliente.getApelido() + "efectuou um registo e tem a seguir " +
                    "alguns dados importantes");


            document.write(fileOutputStream);

        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     */



}
