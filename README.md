# jena-datatensor

## [See the website](https://rdf-tensor.github.io/jena-datatensor/) for more information.

This is a proposed extension to RDF and SPARQL that introduces 2 new datatypes, 36 SPARQL functions, and 6 new aggregates to enhance the processing of data tensors within RDF models. A data tensor is a multi-dimensional array of values, which can be numeric or boolean, commonly used for example in machine learning embeddings.

`example_dataset_and_queries` contains a sligthly modified subset of CS publications knowledge graph, which was a part of [bachelor thesis](https://repo.pw.edu.pl/info/bachelor/WUTb11175cba06e497caab92c07f490c673?r=supervisedwork&ps=20&tab=&title=Engineers%2B%2B%2BBachelors%2Btheses%2B%25E2%2580%2593%2BComputer%2Bscience%2Bpublications%2Bknowledge%2Bgraph%2B%25E2%2580%2593%2BWarsaw%2BUniversity%2Bof%2BTechnology&lang=en) and queries to demonstrate the usage of the implemented functions and aggregates.
This dataset is under fair use license and is provided for educational purposes only.

## Features

- **New Datatypes:**
  - `dt:NumericDataTensor` – Designed for storing tensors containing numeric values.
  - `dt:BooleanDataTensor` – Intended for storing tensors containing boolean values.
- **36 New SPARQL Functions:**
  - Tensor manipulations (addition, multiplication, reshaping, etc.)
  - Algebraic computations
- **6 New Aggregates:**
  - Generalized aggregation functions for numerical tensors
  - Sum, average, variance, and standard deviation computations

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/cinekele/jena-datatensor.git
   cd jena-datatensor/jena-datatensor
   ```
2. Build the project:
   ```sh
   mvn install
   ```
3. Add the generated JAR to your Jena classpath or include it in your project dependencies.

## Implemented datatypes, functions, aggregates, ontology files

**[See the website](https://rdf-tensor.github.io/jena-datatensor/) for more details.**

## Authors, licensing

The extension design and the implementation in Jena were done by **[Piotr Marciniak](https://github.com/cinekele)**. The website and parts of the documentation were done by **[Piotr Sowiński](https://github.com/Ostrzyciel)**.

This repository (except the example dataset under `example_dataset_and_queries/knowledge_graph`) is licensed under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0). The example dataset is used on a fair use basis and is provided for educational / scientific purposes only.
