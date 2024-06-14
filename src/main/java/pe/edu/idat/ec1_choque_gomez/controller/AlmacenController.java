package pe.edu.idat.ec1_choque_gomez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.ec1_choque_gomez.model.AlmacenModel;

@Controller
public class AlmacenController {
    @GetMapping("/almacen")
    public String frmalmacen(Model model){
        model.addAttribute("mostrar",false);
        model.addAttribute("objalmacen",new AlmacenModel());
        return"frmalmacen";
    }

    @PostMapping("/almacen")
    public String calcularPromedio(AlmacenModel almacenModel,Model model){
        Double precio=almacenModel.getPrecio();
        Double cantidad=almacenModel.getCantidad();
        Double descuento= (precio*cantidad)*0.20;
        Double pagototal=precio*cantidad;


        if(pagototal>200){
            pagototal=pagototal-descuento;

        }else {
            pagototal=precio*cantidad;
        }

        model.addAttribute("pagoneto","Su pago total es:"+pagototal+" con descuento de:"+
                descuento);

        model.addAttribute("mostrar",true);
        model.addAttribute("objalmacen",new AlmacenModel());

        return"frmalmacen";
    }



}
