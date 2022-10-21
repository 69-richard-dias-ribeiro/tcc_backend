# tcc_backend
REST API consisting of simple endpoints for manipulating a last known location database.

- Language: Java
- Framework: Spring
- RDBMS: H2 Database
- URL: https://richard-wellington-mavi-api.herokuapp.com/

## Documentation:

HTTP Verb     | Endpoint                     | Function                                | Input [example]
------------- | -----------------------------|-----------------------------------------|-------------------------------------------------------------|
GET           | /ultimaslocalizacoes/        | Get all locations                       |                                                             |
POST          | /ultimaslocalizacoes/        | Insert a location                       | {matricula: ..., ultimaLongitude: ..., ultimaLatitude: ...} |
GET           | /ultimaslocalizacoes/{1}     | Get location by id                      | location's id                                               |
DELETE        | /ultimaslocalizacoes/{1}     | Delete location by id                   | location's id                                               |
PUT           | /preenchercomdadosiniciais/  | Location exists ? uptade it : insert it | {matricula: ..., ultimaLongitude: ..., ultimaLatitude: ...} |     
GET           | /preenchercomdadosiniciais/  | Inserts sample locations                |                                                             |
GET           | /limpartodos                 | Deletes all locations                   |                                                             |
