# Data tensors in RDF

**Unofficial Draft**  
*Date: May 11, 2025*

**Editors:** <br> 
&nbsp;Piotr Sowiński<br>
&nbsp;Piotr Marciniak

---

## Abstract

This specification introduces two new RDF datatypes—`dt:NumericDataTensor` and `dt:BooleanDataTensor`—to represent multi-dimensional arrays (tensors) within RDF and extension of the SPARQL language.
This extension includes 36 functions and 6 aggregates, enabling the efficient processing of tensor data within RDF frameworks.

## Status of This Document

This document is a draft and does not represent an official standard. It is intended for discussion and feedback within the community.

## 1. Introduction

### 1.1. Background and Motivation

*This section is non-normative.*

The growing use of machine learning, particularly language models, demands native support for high-dimensional tensors in RDF and SPARQL. 
Current methods (e.g., RDF collections or reification) are verbose and computationally inefficient. 
This specification provides a compact, performant way to work with numeric and boolean tensors in RDF graphs.

### 1.2. Structure of the Document

*This section is non-normative.*

This document starts by describing the informal motivation and structure of the proposed extensions. It then defines the two new RDF datatypes for tensors, followed by SPARQL function extensions and their semantics. It concludes with usage examples, implementation guidance, and appendices.

### 1.3 Document Conventions

*This section is non-normative.*

Examples in this document assume that the following prefixes have been declared to represent the IRIs shown with them here:

**Prefixes used:**

| Prefix | Namespace                                   |
|--------|---------------------------------------------|
| `ex`  | `http://example.org/data-tensor#`           |
| `dt`  | `https://w3id.org/rdf-tensor/datatypes#`    |
| `dtf` | `https://w3id.org/rdf-tensor/functions#`    |
| `dta` | `https://w3id.org/rdf-tensor/aggregates#`   |


## 2. The `dt:NumericDataTensor` Datatype
### IRI
https://w3id.org/rdf-tensor/datatypes#NumericDataTensor

### Definition

Represents a multi-dimensional array (tensor) of numeric values, encoded in JSON. This datatype explicitly captures the tensor’s shape, numeric type, and flat data values in row-major order.

### Lexical Space

A valid [RFC 8259](https://www.rfc-editor.org/rfc/rfc8259) JSON object **with the following structure**:

| Key     | Type                | Description                                                                                                  |
|---------|---------------------|--------------------------------------------------------------------------------------------------------------|
| `type`  | `string`            | Must be one of: `float16`, `float32`, `float64`, `int16`, `int32`, `int64`. Defines the type of numbers.     |
| `shape` | `array of integers` | Specifies the size of each dimension. The product of the integers must equal the length of the `data` array. |
| `data`  | `array of numbers`  | A flat array of numbers in row-major (C-style) order. Numbers must use decimal or exponential notation.      |

### Value Space

An n-dimensional numeric tensor, where $n$ is the length of shape array.

### Examples

#### Lexical Form

```turtle
ex:x  ex:hasValue "{\"type\": \"float32\", \"shape\": [3, 3],\"data\": [1.2, 3.5, 5.3, 0.1, 1.2, 2.2, 3.2, 4.1, 5.4]}"^^dt:NumericDataTensor .
```

## 3. The `dt:BooleanDataTensor` Datatype


### Definition

Represents a multi-dimensional array (tensor) of boolean values, encoded in JSON. This datatype captures the tensor’s shape and values, with elements stored in row-major (C-style) order. It is useful for expressing structured boolean data in a self-descriptive and human-readable format.

### Lexical Space

A valid [RFC 8259](https://www.rfc-editor.org/rfc/rfc8259) JSON object **with the following structure**:

| Key     | Type                | Description                                                                                                  |
|---------|---------------------|--------------------------------------------------------------------------------------------------------------|
| `shape` | `array of integers` | Specifies the size of each dimension. The product of the integers must equal the length of the `data` array. |
| `data`  | `array of booleans` | A flat array of boolean values (`true` or `false`), stored in row-major (C-style) order.                     |

### Value Space

An n-dimensional boolean tensor, where $n$ is the length of shape array. 

### Example

```turtle
ex:y  ex:hasValue "{\"shape\": [2, 2], \"data\": [true, false, false, true]}"^^dt:BooleanDataTensor .
```

## 4. SPARQL Functions
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


## 5. SPARQL Aggregates

| **IRI (with Turtle prefix)** | **Description**                        |
| -----------------------------|----------------------------------------|
| **dta:sum**                  | Sums grouped tensors                   |
| **dta:avg**                  | Calculates an average tensor           |
| **dta:var**                  | Computes the variance tensor           |
| **dta:std**                  | Computes the standard deviation tensor |

[//]: # (## C. References)

[//]: # (### C.1. Normative References)

[//]: # ()
[//]: # (### C.2. Non-Normative References)