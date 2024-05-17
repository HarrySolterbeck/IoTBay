package uts.iot.controller;

import java.uts.iot.dao.ShipmentDAO;
import model.Shipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/shipments")
public class ShipmentController extends HttpServlet {
    private ShipmentDAO shipmentDAO;

    public void init() {
        Connection connection = Database.getConnection(); // Assume Database.getConnection() provides the DB connection
        shipmentDAO = new ShipmentDAO(connection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertShipment(request, response);
                    break;
                case "delete":
                    deleteShipment(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateShipment(request, response);
                    break;
                default:
                    listShipments(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listShipments(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Shipment> listShipment = shipmentDAO.getAllShipments();
        request.setAttribute("listShipment", listShipment);
        request.getRequestDispatcher("shipment-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("shipment-form.jsp").forward(request, response);
    }

    private void insertShipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String shipmentMethod = request.getParameter("shipmentMethod");
        Date shipmentDate = Date.valueOf(request.getParameter("shipmentDate"));
        String shipmentAddress = request.getParameter("shipmentAddress");

        Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        shipment.setShipmentMethod(shipmentMethod);
        shipment.setShipmentDate(shipmentDate);
        shipment.setShipmentAddress(shipmentAddress);

        shipmentDAO.addShipment(shipment);
        response.sendRedirect("shipments?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));
        Shipment existingShipment = shipmentDAO.getShipment(shipmentId);
        request.setAttribute("shipment", existingShipment);
        request.getRequestDispatcher("shipment-form.jsp").forward(request, response);
    }

    private void updateShipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String shipmentMethod = request.getParameter("shipmentMethod");
        Date shipmentDate = Date.valueOf(request.getParameter("shipmentDate"));
        String shipmentAddress = request.getParameter("shipmentAddress");

        Shipment shipment = new Shipment();
        shipment.setShipmentId(shipmentId);
        shipment.setOrderId(orderId);
        shipment.setShipmentMethod(shipmentMethod);
        shipment.setShipmentDate(shipmentDate);
        shipment.setShipmentAddress(shipmentAddress);

        shipmentDAO.updateShipment(shipment);
        response.sendRedirect("shipments?action=list");
    }

    private void deleteShipment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));
        shipmentDAO.deleteShipment(shipmentId);
        response.sendRedirect("shipments?action=list");
    }
}
