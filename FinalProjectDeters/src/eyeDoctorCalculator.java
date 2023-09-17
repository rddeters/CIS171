/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 24th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class eyeDoctorCalculator {
    // Constants for exam and contact lens rates, and tax rate
    private static final double NEW_PATIENT_RATE = 119.00;
    private static final double EXISTING_PATIENT_RATE = 109.00;
    private static final double CONTACT_LENS_RATE = 70.00;
    private static final double TAX_RATE = 0.07;

    // Calculate the cost of an eye exam based on whether the patient is new or existing.
    public static double calculateExamCost(boolean isNewPatient) {
        if (isNewPatient) {
            // Return the rate for new patients if isNewPatient is true
            return NEW_PATIENT_RATE;
        } else {
            // Return the rate for existing patients if isNewPatient is false
            return EXISTING_PATIENT_RATE;
        }
    }

    // Calculate the additional cost for contact lenses based on whether the patient wears contacts.
    public static double calculateContactCost(boolean wearsContacts) {
        if (wearsContacts) {
            // Return the rate for patients who wear contacts if wearsContacts is true
            return CONTACT_LENS_RATE;
        } else {
            // Return 0.0 if the patient does not wear contacts
            return 0.0;
        }
    }

    // Calculate the total cost by adding the exam cost and contact cost and applying the tax rate.
    public static double calculateTotalCost(double examCost, double contactCost) {
        // Calculate the subtotal by adding the exam cost and contact cost
        double subtotal = examCost + contactCost;

        // Calculate the tax by applying the tax rate to the subtotal
        double tax = subtotal * TAX_RATE;

        // Return the total cost by adding the subtotal and tax
        return subtotal + tax;
    }
}

