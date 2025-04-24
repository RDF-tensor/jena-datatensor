# jena-datatensor

`jena-datatensor` is an extension for Apache Jena that introduces 2 new datatypes, 36 SPARQL functions, and 6 new aggregators to enhance the processing of data tensors within RDF models.

`example_dataset_and_queries` contains a sligthly modified subset of CS publications knowledge graph, which was a part of [bachelor thesis](https://repo.pw.edu.pl/info/bachelor/WUTb11175cba06e497caab92c07f490c673?r=supervisedwork&ps=20&tab=&title=Engineers%2B%2B%2BBachelors%2Btheses%2B%25E2%2580%2593%2BComputer%2Bscience%2Bpublications%2Bknowledge%2Bgraph%2B%25E2%2580%2593%2BWarsaw%2BUniversity%2Bof%2BTechnology&lang=en) and queries to demonstrate the usage of the implemented functions and aggregators.
This dataset is under fair use license and is provided for educational purposes only.

## Features

- **New Datatypes:**
  - `dt:NumericDataTensor` – Designed for storing tensors containing numeric values.
  - `dt:BooleanDataTensor` – Intended for storing tensors containing boolean values.
- **36 New SPARQL Functions:**
  - Tensor manipulations (addition, multiplication, reshaping, etc.)
  - Algebraic computations
- **6 New Aggregators:**
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

## Implemented Functions

The table below lists the implemented SPARQL functions, including their input arguments, return values, and associated IRI (with the `dtf` prefix set to `https://w3id.org/rdf-tensor/functions#`).

### Transforming Functions

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:cos` | Applies cosine function | One numerical tensor | Tensor with same shape |
| `dtf:exp` | Applies exponential function | One numerical tensor | Tensor with same shape |
| `dtf:log` | Applies natural logarithm | One numerical tensor | Tensor with same shape |
| `dtf:logp` | Logarithm with base p | Number (p), numerical tensor | Tensor with same shape |
| `dtf:poly` | Raises elements to power | Number, numerical tensor | Tensor with same shape |
| `dtf:scale` | Scales tensor elements | Number, numerical tensor | Tensor with same shape |
| `dtf:sin` | Applies sine function | One numerical tensor | Tensor with same shape |
| `dtf:abs` | Applies absolute value | One numerical tensor | Tensor with same shape |

### Operators

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:not` | Logical NOT operation | One boolean tensor | Boolean tensor |
| `dtf:add` | Element-wise addition | Two numerical tensors | Numerical tensor (broadcasted) |
| `dtf:subtract` | Element-wise subtraction | Two numerical tensors | Numerical tensor (broadcasted) |
| `dtf:multiply` | Element-wise multiplication | Two numerical tensors | Numerical tensor (broadcasted) |
| `dtf:divide` | Element-wise division | Two numerical tensors | Numerical tensor (broadcasted) |
| `dtf:eq` | Element-wise equality check | Two tensors | Boolean tensor (broadcasted) |
| `dtf:neq` | Element-wise inequality check | Two tensors | Boolean tensor (broadcasted) |
| `dtf:and` | Logical AND operation | Two boolean tensors | Boolean tensor (broadcasted) |
| `dtf:or` | Logical OR operation | Two boolean tensors | Boolean tensor (broadcasted) |
| `dtf:gt` | Element-wise greater than comparison | Two numerical tensors | Boolean tensor (broadcasted) |
| `dtf:lt` | Element-wise less than comparison | Two numerical tensors | Boolean tensor (broadcasted) |

### Indexing Functions

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:getSubDT` | Extracts sub-tensor | One numerical tensor, second tensor (numerical/boolean) | Sub-tensor |

### Concatenating Functions

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:concat` | Concatenates tensors | Two tensors, optional dimension | Combined tensor |
| `dtf:hstack` | Horizontally stacks tensors | Two tensors | Horizontally combined tensor |
| `dtf:vstack` | Vertically stacks tensors | Two tensors | Vertically combined tensor |

### Reduction Functions

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:all` | Checks if all elements are true | Boolean tensor | Boolean scalar |
| `dtf:any` | Checks if any element is true | Boolean tensor | Boolean scalar |
| `dtf:avg` | Computes average | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:sum` | Computes sum | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:max` | Computes maximum | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:median` | Computes median | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:min` | Computes minimum | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:std` | Computes standard deviation | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:var` | Computes variance | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:norm1` | Computes L1 norm | Axis (number), numerical tensor | Reduced tensor (or scalar) |
| `dtf:norm2` | Computes L2 norm | Axis (number), numerical tensor | Reduced tensor (or scalar) |

### Similarity Functions

| **IRI** | **Function** | **Input Arguments** | **Return Value** |
|---------|-------------|---------------------|------------------|
| `dtf:cosineSimilarity` | Computes cosine similarity | Two numerical tensors | Numeric scalar |
| `dtf:euclideanDistance` | Computes Euclidean distance | Two numerical tensors | Numeric scalar |


## Implemented Aggregators

The table below lists the implemented aggregation functions, which operate on `NumericDataTensor` inputs and return `NumericDataTensor` results. These aggregators generalize standard aggregation functions for numerical tensors and do not support the `DISTINCT` keyword.
The `dta` prefix set to `https://w3id.org/rdf-tensor/aggregators#`)

| **IRI (with Turtle prefix)** | **Description**                        |
| -----------------------------|----------------------------------------|
| **dta:sum**                  | Sums grouped tensors                   |
| **dta:avg**                  | Calculates an average tensor           |
| **dta:var**                  | Computes the variance tensor           |
| **dta:std**                  | Computes the standard deviation tensor |

