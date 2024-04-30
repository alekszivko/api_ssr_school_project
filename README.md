# Collaborative school project

An unfinished example project written in school. Has api endpoints as well as server side
rendered templates

Runs by default on port 8080.

Usage:

Run the application with (Docker required/uses testcontainers):

mvn exec:java -Dexec.mainClass="at.spengergasse.sj2324seedproject.TestMainApplication"
-Dexec.classpathScope="test"

**Content**

1. [API Definition](#OpenAPI-definition)
2. [SSR](#SSR-Endpoints)

## OpenAPI definition

<details>
<summary>Details</summary>

#### /api/storageObjectMeta

##### GET

###### Parameters

| Name      | Located in | Description | Required | Schema |
|-----------|------------|-------------|----------|--------|
| nameParam | query      |             | No       | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

##### POST

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/reservations

##### GET

###### Parameters

| Name      | Located in | Description | Required | Schema  |
|-----------|------------|-------------|----------|---------|
| completed | query      |             | No       | boolean |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

##### POST

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/producer

##### GET

###### Parameters

| Name      | Located in | Description | Required | Schema |
|-----------|------------|-------------|----------|--------|
| nameParam | query      |             | No       | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

##### POST

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/storage

##### GET

###### Parameters

| Name     | Located in | Description | Required | Schema |
|----------|------------|-------------|----------|--------|
| namePart | query      |             | No       | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/storageObjects

##### GET

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/storageObjects/{mac}

##### GET

###### Parameters

| Name       | Located in | Description | Required | Schema |
|------------|------------|-------------|----------|--------|
| macAddress | query      |             | No       | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/storageObjectMeta/metaName

##### GET

###### Parameters

| Name | Located in | Description | Required | Schema |
|------|------------|-------------|----------|--------|
| name | query      |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/reservations/{id}

##### GET

###### Parameters

| Name | Located in | Description | Required | Schema |
|------|------------|-------------|----------|--------|
| id   | path       |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/producer/{id}

##### GET

###### Parameters

| Name | Located in | Description | Required | Schema |
|------|------------|-------------|----------|--------|
| id   | path       |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/producer/api/producer/{id}

##### GET

###### Parameters

| Name  | Located in | Description | Required | Schema |
|-------|------------|-------------|----------|--------|
| idVal | query      |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/customers

##### GET

###### Parameters

| Name         | Located in | Description | Required | Schema |
|--------------|------------|-------------|----------|--------|
| connectionNo | query      |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 200  | OK          |

#### /api/producer/{delShortname}

##### DELETE

###### Parameters

| Name         | Located in | Description | Required | Schema |
|--------------|------------|-------------|----------|--------|
| delShortname | path       |             | Yes      | string |

###### Responses

| Code | Description |
|------|-------------|
| 204  | No Content  |

</details>    

## SSR Endpoints

<details>
<summary>Details</summary>

* /reservations
* /reservations/new
* /reservations/edit/\<key>

* /storageObjects
* /storageObjects/new
* /storageObjects/edit/\<key>

* /storages
* /storages/new
* /storages/edit/\<id>

</details>
