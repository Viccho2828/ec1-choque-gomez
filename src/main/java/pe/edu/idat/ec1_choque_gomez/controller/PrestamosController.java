package pe.edu.idat.ec1_choque_gomez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ec1_choque_gomez.model.AlmacenModel;
import pe.edu.idat.ec1_choque_gomez.model.PrestamosModel;
@Controller
public class PrestamosController {

    @GetMapping("/prestamos")
    public String frmprestamos(Model model){
        model.addAttribute("mostrar",false);
        model.addAttribute("objprestamos",new PrestamosModel());
        return"frmprestamos";
    }

    @PostMapping("/prestamos")
    public String calcularPrestamos(PrestamosModel prestamosModel, Model model){
        Double importe=prestamosModel.getImporte();
        String numerocuota="";
        Double interes=0.0;
        if(importe>5000){
            numerocuota="3 cuotas";

        } else if (importe<1000) {
            numerocuota="1 cuota";
        } else if ((importe > 2000) & (importe < 3000)) {
            numerocuota="2 cuota";
        } else {
            numerocuota="5 cuotas";
        }

        if (importe<4000){
            interes=importe*0.12;
        }else {
            interes=importe*0.10;
        }
        model.addAttribute("interes","El numero de cuotas es:"+numerocuota +" y el interes generado es:"+ interes);

        model.addAttribute("mostrar",true);
        model.addAttribute("objprestamos",new PrestamosModel());

        return"frmprestamos";
    }


}
