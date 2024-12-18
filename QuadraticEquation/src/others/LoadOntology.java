/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package others;

/**
 *
 * @author Home
 */
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;

public class LoadOntology {

    private static OWLOntology ontology;

    public static void loadOntology(String filePath) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        File file = new File(filePath);
        ontology = manager.loadOntologyFromOntologyDocument(file);
        System.out.println("Ontology loaded: " + ontology.getOntologyID());
    }

    public static OWLOntology getOntology() {
        return ontology;
    }
}