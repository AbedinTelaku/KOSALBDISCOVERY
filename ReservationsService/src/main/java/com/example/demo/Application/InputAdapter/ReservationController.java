package com.example.demo.Application.InputAdapter;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.example.demo.Core.Domain.ReservationInvoice;
import com.example.demo.Core.Entities.Reservation;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @Autowired
    private ReservationInputPort reservationInputPort;

    public ReservationController(ReservationInputPort reservationInputPort) {
        this.reservationInputPort = reservationInputPort;
    }

    @PostMapping("/create")
    public void createReservation(){

    }

    @GetMapping("/export/PDF{id}")
    public void exportToPDF(@PathVariable("id") int id, HttpServletResponse response) throws DocumentException, IOException {

        Reservation reservation=this.reservationInputPort.getReservationById(id);

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=reservation_"+reservation.getId()+"_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);



        ReservationInvoice invoiceExporter = new ReservationInvoice(reservation);
        invoiceExporter.export(response);

    }
}
