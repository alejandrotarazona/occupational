clear

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initCompanies
echo ""
echo "Finalizado Companies"
read -rsp $'Press any key to continue...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initPosts
echo ""
echo "Finalizado Companies"
read -rsp $'Press any key to continue...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initVitals
echo ""
echo "Finalizado VitalSigns"
read -rsp $'Press any key to continue...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initUsers
echo ""
echo "Finalizado Usuarios"
read -rsp $'Press any key to continue...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initDoctors
echo ""
echo "Finalizado Doctores"
read -rsp $'Press any key to continue...\n' -n1 key

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/occupational/initPatients
echo ""
echo "Finalizado Pacientes"
