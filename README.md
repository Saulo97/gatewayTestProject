# gatewayTestProject
#Todo el proyecto se encuentra en la rama main #Es necesario crear una base de datos SQL y agregar al archivo application.properties la url de dicha base de datos, asi como el usuario y la contraseña configurada #Para probar la aplicacion es necesario entrar en el navegador a la siguiente direccion localhost:8080/ #localhost:8080/Gateways/createGateway endPoint para registrar un nuevo gateway con la siguiente estructura: {
"serialNumber":"aa123", "name":"aaa", "ipv4":"192.122.122.122" } es necesario registrar al menos un drone para continuar probando la aplicacion

#localhost:8080/Gateways/getAllGateways Endpoint para obtener un listado de todos los gateways y sus devices conectados

#localhost:8080/Gateways/getGateway/{id} EndPoint para obtener los detalles de un gateways, asi como sus devices asociados #localhost:8080/Gateways/addDeviceToGateway/{id} Endpoint para agregar un device conectado a un gateways, donde el id del gateway debe ser enviado por query params y el device debe tener la siguiente estructura: { "uid":141431, "vendor":"paaaa", "status":"ONLINE" } donde el campo status solo acepta los valores "ONLINE" y "OFFLINE" #localhost:8080/Gateways/deleteDevice/{id} Endpoint para eliminar un device pasando como query params su id
