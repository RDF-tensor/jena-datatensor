# Data tensors in RDF

This is a proposed extension to RDF and SPARQL that introduces 2 new datatypes, 36 SPARQL functions, and 6 new aggregates to enhance the processing of data tensors within RDF models. A data tensor is a multi-dimensional array of values, which can be numeric or boolean, commonly used for example in machine learning embeddings.

## General information

The proposed approach is described in an ESWC 2025 poster, that will be posted soon as a preprint.

It was implemented in Apache Jena – **[see the installation instructions on GitHub](https://github.com/RDF-tensor/jena-datatensor)**.

Ontology files for the new datatypes, functions, and aggregates are available. See:

- [Datatypes](ontology/datatypes.md)
- [Functions](ontology/functions.md)
- [Aggregates](ontology/aggregates.md)

### Example dataset and queries

See an [example dataset and queries on GitHub](https://github.com/RDF-tensor/jena-datatensor/tree/main/example_dataset_and_queries).

### Authors

The extension design and the implementation in Jena were done by **[Piotr Marciniak](https://github.com/cinekele)**. The website and parts of the documentation were done by **[Piotr Sowiński](https://github.com/Ostrzyciel)**.

The contents of this website are licensed under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Features

- **2 new datatypes:**
    - `dt:NumericDataTensor` – Designed for storing tensors containing numeric values.
    - `dt:BooleanDataTensor` – Intended for storing tensors containing boolean values.
- **36 new SPARQL functions:**
    - Tensor manipulations (addition, multiplication, reshaping, etc.)
    - Algebraic computations
- **6 new aggregates:**
    - Generalized aggregation functions for numerical tensors
    - Sum, average, variance, and standard deviation computations

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


## Implemented Aggregates

The table below lists the implemented aggregation functions, which operate on `NumericDataTensor` inputs and return `NumericDataTensor` results. These aggregates generalize standard aggregation functions for numerical tensors and do not support the `DISTINCT` keyword.
The `dta` prefix set to `https://w3id.org/rdf-tensor/aggregates#`)

| **IRI (with Turtle prefix)** | **Description**                        |
| -----------------------------|----------------------------------------|
| **dta:sum**                  | Sums grouped tensors                   |
| **dta:avg**                  | Calculates an average tensor           |
| **dta:var**                  | Computes the variance tensor           |
| **dta:std**                  | Computes the standard deviation tensor |
