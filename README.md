
<h2> 1 - Créer un principal du service</h2>

Définition   : (Application, Service ou plateforme ) ----utiliser---> Service Principal (identité) ---- accéder ---> au ressource azure (Ici Azure key vault).

Commande CLI : az ad sp create-for-rbac --name naitech

Retour de la commande :

{<br/>
  "appId": "aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee",<br/>
  "displayName": "naitech",<br/>
  "name": "aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee",<br/>
  "password": "xxxxxx.yyyyyyyyyyyyyyyyyyyyyyyyyyyy",<br/>
  "tenant": "dddddddd-pppp-gggg-pppp-uuuuuuuuuuuu"<br/>
}

<h2>2 - Récupération de la liste des régions azure</h2>

Commande CLI : az account list-locations --output table

<h2>3 - Création d'un ressource groupe</h2>

Commande CLI : az group create --name azureKeyVault --location eastus

<h2>4 - Création de l'instance keyvault</h2>

Commande CLI : az keyvault create --resource-group azureKeyVault --name naitechKeyVault --location eastus --query properties.vaultUri --sku standard

Retour de la commande : "https://naitechkeyvault.vault.azure.net/"

<h2>5 - Autoriser les opérations get et list à partir de l'identité managée service principal </h2>

az keyvault set-policy --name naitechKeyVault --spn aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee --secret-permissions get list

<h2>6 - Ajout des secret dans le keyvault </h2>
Commande CLI : az keyvault secret set --name "login" --vault-name "naitechKeyVault" --value "myLogin" <br/><br/>
Commande CLI : az keyvault secret set --name "password" --vault-name "naitechKeyVault" --value "myPassword"