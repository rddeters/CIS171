/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 24th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class eyeDoctorTest {
    // Constants for exam and contact lens rates, and tax rate (copied from eyeDoctorCalculator)
    double NEW_PATIENT_RATE = 119.00;
    double EXISTING_PATIENT_RATE = 109.00;
    double CONTACT_LENS_RATE = 70.00;
    double TAX_RATE = 0.07;
	
    // Test for calculateExamCost() method when the patient is new
    @Test
    void testCalculateExamCostNewPatient() {
        double expectedCostForNewPatient = NEW_PATIENT_RATE;
        double actualCostForNewPatient = eyeDoctorCalculator.calculateExamCost(true);
        assertEquals(expectedCostForNewPatient, actualCostForNewPatient);
    }
    
    // Test for calculateExamCost() method when the patient is existing
    @Test
    void testCalculateExamCostExistingPatient() {
        double expectedCostForExistingPatient = EXISTING_PATIENT_RATE;
        double actualCostForExistingPatient = eyeDoctorCalculator.calculateExamCost(false);
        assertEquals(expectedCostForExistingPatient, actualCostForExistingPatient);
    }

    // Test for calculateContactCost() method when the patient wears contacts
    @Test
    void testCalculateContactCost() {
        double expectedCostForWearsContacts = CONTACT_LENS_RATE;
        double actualCostForWearsContacts = eyeDoctorCalculator.calculateContactCost(true);
        assertEquals(expectedCostForWearsContacts, actualCostForWearsContacts);
    }
    
    // Test for calculateContactCost() method when the patient does not wear contacts
    @Test
    void testCalculateContactCostNoContacts() {
        double expectedCostForNoContacts = 0.0;
        double actualCostForNoContacts = eyeDoctorCalculator.calculateContactCost(false);
        assertEquals(expectedCostForNoContacts, actualCostForNoContacts);
    }

    // Test for calculateTotalCost() method when the patient is new and wears contacts
    @Test
    void testCalculateTotalCostNewContacts() {
        // Set up the expected total cost based on the subtotal and tax rate calculation
        double examCost = NEW_PATIENT_RATE;
        double contactCost = CONTACT_LENS_RATE;
        double subtotal = examCost + contactCost;
        double expectedTotalCost = subtotal + (subtotal * TAX_RATE);

        // Calculate the actual total cost using the method to be tested
        double actualTotalCost = eyeDoctorCalculator.calculateTotalCost(examCost, contactCost);

        // Assert that the actual total cost matches the expected total cost
        assertEquals(expectedTotalCost, actualTotalCost);
    }
    
    // Test for calculateTotalCost() method when the patient is existing and does not wear contacts
    @Test
    void testCalculateTotalCostExistingNoContacts() {
        // Set up the expected total cost based on the subtotal and tax rate calculation
        double examCost = EXISTING_PATIENT_RATE;
        double contactCost = 0; // No contact cost for patients without contacts
        double subtotal = examCost + contactCost;
        double expectedTotalCost = subtotal + (subtotal * TAX_RATE);

        // Calculate the actual total cost using the method to be tested
        double actualTotalCost = eyeDoctorCalculator.calculateTotalCost(examCost, contactCost);

        // Assert that the actual total cost matches the expected total cost
        assertEquals(expectedTotalCost, actualTotalCost);
    }
}
