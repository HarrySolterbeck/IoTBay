package ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Shipment;

@Stateless
public class ShipmentSessionBean {

    @PersistenceContext(unitName = "yourPersistenceUnit")
    private EntityManager em;

    public void addShipment(Shipment shipment) {
        em.persist(shipment);
    }

    public void updateShipment(Shipment shipment) {
        em.merge(shipment);
    }

    public void deleteShipment(int shipmentId) {
        Shipment shipment = em.find(Shipment.class, shipmentId);
        if (shipment != null) {
            em.remove(shipment);
        }
    }

    public Shipment findShipment(int shipmentId) {
        return em.find(Shipment.class, shipmentId);
    }
}
