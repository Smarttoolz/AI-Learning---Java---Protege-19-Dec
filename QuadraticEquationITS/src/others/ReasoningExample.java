/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package others;

/**
 *
 * @author Home
 */
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class ReasoningExample {

    public static String inferAndCheckRootType(String discriminantValue, double a, double b, double c) {
    try {
        // Load the ontology
        OWLOntology ontology = LoadOntology.getOntology();
        OWLDataFactory dataFactory = ontology.getOWLOntologyManager().getOWLDataFactory();
        
        // Create the reasoner
        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);

        // Parse the discriminant value
        double parsedDiscriminant = Double.parseDouble(discriminantValue);

        // Calculate the discriminant manually for correctness checking
        double calculatedDiscriminant = Math.pow(b, 2) - (4 * a * c);

        // Check if the calculated discriminant matches the provided discriminant
        if (Math.abs(calculatedDiscriminant - parsedDiscriminant) > 1e-6) {
            return "Error: Discriminant value is incorrect.";
        }

        // Determine the root type based on the discriminant
        OWLNamedIndividual rootTypeIndividual;
        if (calculatedDiscriminant > 0) {
            rootTypeIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontology.getOntologyID().getOntologyIRI() + "#RealRoot"));
        } else if (calculatedDiscriminant == 0) {
            rootTypeIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontology.getOntologyID().getOntologyIRI() + "#RepeatedRoot"));
        } else {
            rootTypeIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontology.getOntologyID().getOntologyIRI() + "#ComplexRoot"));
        }

        // Verify correctness of inferred root type with ontology
        if (reasoner.isEntailed(dataFactory.getOWLClassAssertionAxiom(
                dataFactory.getOWLClass(IRI.create(ontology.getOntologyID().getOntologyIRI() + "#RootType")), 
                rootTypeIndividual))) {
            return "Correct: " + rootTypeIndividual.getIRI().getShortForm() + " inferred successfully.";
        } else {
            return "Error: Root type inference failed or inconsistent with ontology.";
        }

    } catch (Exception e) {
        e.printStackTrace();
        return "Error inferring root type";
    }
}

}
