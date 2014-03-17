package comanche;
import comanche.model.CommandeDynamic;
import comanche.model.CommandeException;
import comanche.model.CommandeFichier;
import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import java.io.*;

public class FileRequestHandler implements RequestHandler, BindingController {

  private CommandRequestHandler commandRequestHandler;

  // functional aspect
  public void handleRequest (Request r) throws IOException {

      String[] commands=new String[0];
      if(r.url.contains(":")){
          if(commandRequestHandler!=null){
              commandRequestHandler.handleRequest(r);
          }

          String cmds=r.url.split(":")[1];
          r.url=r.url.split(":")[0];
          commands=cmds.split(",");

      }
      File f = new File(r.url);
    if (f.exists() && !f.isDirectory()) {
      InputStream is = new FileInputStream(f);
      byte[] data = new byte[is.available()];
      is.read(data);
      is.close();
      r.out.print("HTTP/1.0 200 OK\n\n");
      r.out.write(data);
    }
    else if (f.exists() && f.isDirectory()) {
        String[] names=f.list();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("<html><body>");
        stringBuilder.append("<b>Dossier : " + f.getName() + "</b><br/>");
        stringBuilder.append("<table>");
        for(String name:names){
            stringBuilder.append("<tr>");
            stringBuilder.append("<td><a href='"+f.getName()+"/"+name+"'>");
            stringBuilder.append(name);
            stringBuilder.append("</a>");
            stringBuilder.append("</td>");

            for(String cmd:commands){
                CommandeDynamic commandeDynamic=commandRequestHandler.getCommandeFichier().get(cmd);
                if(commandeDynamic!=null){
                    CommandeFichier commandeFichier= (CommandeFichier) commandeDynamic.getInstanceCommande();
                    try {
                        commandeFichier.setFichier(new File(f.getAbsolutePath()+"/"+name));
                        commandeFichier.executer();
                        String result=commandeFichier.getResultat();
                        stringBuilder.append("<td>");
                        stringBuilder.append(result);
                        stringBuilder.append("</td>");
                    } catch (CommandeException e) {
                        e.printStackTrace();
                    }
                }
            }
            stringBuilder.append("</tr>");
        }


        stringBuilder.append("</body></html>");
        byte[] data = stringBuilder.toString().getBytes();
        r.out.print("HTTP/1.0 200 OK\n\n");
        r.out.write(data);
    }
    else if (r.url.equals("")) {
        f = new File("index.html");
        System.out.println("Loading default file: " + f);
        if (f.exists()) {
            InputStream is = new FileInputStream(f);
            byte[] data = new byte[is.available()];
            is.read(data);
            is.close();
            r.out.print("HTTP/1.0 200 OK\n\n");
            r.out.write(data);
        }
        else {
            throw new IOException("File not found");
        }
    }
    else {
        throw new IOException("File not found");
    }
  }

    // configuration aspect
    @Override
    public String[] listFc() {
        return new String[]{"rc"};
    }

    @Override
    public Object lookupFc(String s) throws NoSuchInterfaceException {
        if (s.equals("rc")) { return commandRequestHandler; }
        else return null;
    }

    @Override
    public void bindFc(String s, Object o)  {
        if (s.equals("rc")) { commandRequestHandler = (CommandRequestHandler)o; }
    }

    @Override
    public void unbindFc(String s) {
        if (s.equals("rc")) { commandRequestHandler = null; }
    }
}
