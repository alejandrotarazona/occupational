clear

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initCompanies
echo ""
echo ""
echo "Finalizado Companies"
read -rsp $'Procediendo a Puestos, presione cualquier tecla para continuar...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initPosts
echo ""
echo ""
echo "Finalizado Posts"
read -rsp $'Procediendo a Usuarios, presione cualquier tecla para continuar...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initUsers
echo ""
echo ""
echo "Finalizado Usuarios"
read -rsp $'PProcediendo a Doctores, presione cualquier tecla para continuar...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initDoctors
echo ""
echo ""
echo "Finalizado Doctores"
read -rsp $'Procediendo a Pacientes, presione cualquier tecla para continuar...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initPatients
echo ""
echo ""
echo "Finalizado Pacientes"

