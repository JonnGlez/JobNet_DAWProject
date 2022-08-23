package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

   /*
    * Metodo utilizado por un administrador para enviar un correo electronico al
    * usuario que envio su CV.
    * Para enviar el correo se hace uso de una cuenta de correo eletronico de tipo
    * gmail.
    * Nota: Para poder usar tu cuenta de gmail para enviar correos desde esta
    * aplicaciones externas, por ejemplo desde esta aplicacion
    * debes de realizar lo siguiente:
    * 
    * 1. Haz login en tu cuenta de gmail.
    * 2. Abre la URL: https://www.google.com/settings/security/lesssecureapps.
    * 3. Activa la opcion "Acceso de aplicaciones menos seguras".
    * 
    */

   /**
    * 
    * @param mailDestino
    * @param Asunto
    * @param Mensaje
    * @return
    */
   public String sendMail(String mailDestino, String Asunto, String Mensaje) {
      String response = null;
      try {
         // Propiedades de la conexión del servidor de Correo
         Properties props = new Properties();
         props.setProperty("mail.smtp.host", "smtp.gmail.com");
         props.setProperty("mail.smtp.starttls.enable", "true");
         props.setProperty("mail.smtp.port", "587");
         // La direccion de correo de gmail que sera la usada para enviar el correo.
         props.setProperty("mail.smtp.user", "**************"); // cuenta de email que utilizaremos
         props.setProperty("mail.smtp.auth", "true");

         // Preparamos la sesion
         Session session = Session.getDefaultInstance(props);

         // Construimos el mensaje de correo electronico
         MimeMessage message = new MimeMessage(session);
         // De quien va a llegar el correo
         message.setFrom(new InternetAddress("***********")); // debe ser la misma cuenta de email de la configuracion
                                                              // de arriba
         /* Indicamos correo destinatario */
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDestino));
         /* Asunto del Correo electronico */
         message.setSubject(Asunto);
         /* El mensaje del correo electronico */
         message.setText(Mensaje);
         // Enviamos el correo electronico
         Transport t = session.getTransport("smtp");
         /*
          * Establecemos los datos de conexion para la cuenta de gmail. La misma de
          * arriba
          */
         t.connect("*************", "*********"); // Esta es la contraseña de la cuenta de email que se usara para
                                                  // enviar el correo
         t.sendMessage(message, message.getAllRecipients());
         // Cierre.
         t.close();
         response = "El correo electrónico fue enviado correctamente.";
         return response;
      } catch (Exception e) {
         System.out.println("Error Mail.sendMail: " + e.getMessage());
         response = e.getMessage();
         return response;
      }
   }
}
