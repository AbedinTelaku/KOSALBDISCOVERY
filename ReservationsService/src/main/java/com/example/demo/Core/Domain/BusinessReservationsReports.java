package com.example.demo.Core.Domain;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BusinessReservationsReports {

    @Autowired
    private ReservationInputPort reservationInputPort;

    public void export(HttpServletResponse httpServletResponse) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());


        document.open();


    }
}
