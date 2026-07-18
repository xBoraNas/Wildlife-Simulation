# Wildlife Simulation and Conservation System 🦁🛡️

A comprehensive Java-based simulation and management system designed to model a wildlife reserve operation. The system coordinates the delicate balance between habitats, dynamic animal behaviors, ranger patrols, support vehicles, and anti-poaching security enforcement. 

This repository includes the core simulation framework, configuration data, architectural diagrams, and robust JUnit test coverage[cite: 5, 11, 12, 15, 16].

## 🚀 Key Simulation Mechanics

* **Dynamic Behavior & State Lifecycle:** Animals operate on a complete behavioral lifecycle, shifting through states (`CALM`, `ALERTED`, `CRITICAL`, `STABILIZED`, etc.) based on environmental stimuli and health/stress metrics[cite: 5, 6].
* **Temperament Profiles:** Individual animal temperaments (`PASSIVE`, `DEFENSIVE`, `CURIOUS`, `AGGRESSIVE`) dynamically dictate their unique operational response rules when cornered or approached[cite: 5, 6].
* **Ranger Security & Support:** Diligent rangers manage animal health/stress levels (`assistAnimal()`, `helpAnimal()`) and defend the park perimeter from armed intruders[cite: 5, 9].
* **Intruder Incursions:** Poachers infiltrate the reserve targeting specific endangered species, actively triggering zone-wide structural stress (`causeIncursionStress()`)[cite: 5, 7, 8].
* **Logistics & Asset Management:** Operates a fleet of support vehicles fitted with tactical kits like `TRANQUILLISER_KIT` or `MOBILE_MEDIC_UNIT` to expedite remote emergency rescues[cite: 5, 10].
* **Robust File Operations:** Automatically loads data configurations dynamically from text inputs (`habitats.txt`, `animals.txt`, etc.) utilizing efficient token scanners[cite: 11].

## 📊 Documentation & Visuals

The complete technical framework is formally detailed within the repository to validate system architecture before runtime analysis[cite: 5]:
* **Structural Blueprints:** Includes a full UML Class Diagram mapping interactions between manager utilities and entity components[cite: 5].
* **Lifecycle State Machine:** Features an explicit State Diagram modeling structural shifts between calm, defensive, fleeing, and critical statuses[cite: 5].
* **Interaction Lifelines:** Incorporates Sequence Diagrams tracing complex field scenarios such as Hostile Animal Encounters and Field Emergency Treatments[cite: 5].
* **Technical Report:** A formal documentation file (`BigAssignmentDocumentation.docx`) is included, detailing method behaviors and simulation requirements[cite: 5].

## 📦 Project Structure & Package Architecture

The simulation is packaged under `wildlifesimulation` and incorporates the following core classes[cite: 6]:

* **`WildlifeSimulation`**: The main manager orchestration class; handles data ingestion pipelines and coordinates daily game reserve status checks[cite: 5, 11].
* **`Animal`**: Governs physiological metrics (health, stress) along with structural state lifecycle machines[cite: 5, 6].
* **`Habitat`**: Zone containers holding tracked wildlife records while validating local carrying capacity limits[cite: 5, 7].
* **`Ranger` & `Poacher`**: Opposing entity profiles managing custom combat matrices, experience growth, and target mapping[cite: 5, 8, 9].
* **`Vehicle`**: Transports tactical responders and operates equipment suites during field maneuvers[cite: 5, 10].

---

## 🧪 Quality Assurance & Unit Testing

The system boasts a robust suite of JUnit 4 unit tests to ensure computational integrity under strict boundaries:
* **`AnimalTest`**: Validates structural status modification parameters (`updateStatus`) and confirms strict floor clamps on negative stress values[cite: 12].
* **`HabitatTest`**: Asserts capacity compliance rules and ensures stress spikes propagate properly during zone invasions[cite: 13].
* **`PoacherTest`**: Assures hunting algorithms apply exclusively to targeted species without damaging unrelated wildlife assets[cite: 14].
* **`RangerTest`**: Tests field assistance efficiency, custom stress mitigation mechanisms, and conditional combat victory models against incoming threat levels[cite: 15].
* **`VehicleTest`**: Validates structural replenishment limits (`refuel()`) and ensures maximum resource capping operates reliably[cite: 16].

---

## 🛠️ Requirements & Installation

* **Language:** Java 8 or higher
* **Testing:** JUnit 4 Framework[cite: 12]
* **IDE Support:** NetBeans, IntelliJ IDEA, Eclipse

### Running the Application (CLI)
Ensure configurations (`habitats.txt`, `animals.txt`, `poachers.txt`, `vehicles.txt`, `rangers.txt`) are present in the runtime path[cite: 11]. Then run:
```bash
javac WildlifeSimulation/src/wildlifesimulation/*.java
java -cp WildlifeSimulation/src wildlifesimulation.WildlifeSimulation