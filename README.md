# ElFamossoPingPong
Projet Java CIR3 - ISEN Lille

#Tuto git :

--------
**Créer un dépot git :**
- Créer un dossier dans le répertoire apache (Pour démarrer apache2 : Ubuntu : "`sudo service apache2 start`"; Fedora : "`sudo systemctl start httpd`")
- Ouvrir le terminal et se placer dans le dossier créer
- Taper "`git init`"
- Taper "`git remote add NomDuProjet LienDuDépotGit`" (ici de préférence : "`git remote add origin https://github.com/LucasDenele/ProjetWebCIR2.git`")

--------
**Récupérer le dépot git ainsi que les changements :**
- Ouvrir le terminal et se placer dans le dossier du dépot git
- Taper "`git pull NomDuProjet NomDeLaBranche`" (ici de préférence : "`git pull origin master`")

--------
**Ajouter/Changements d'un (ou plusieurs) fichier(s) sur le dépot git :**
- Toujours pareil
- Vérifier que l'on a bien *pull* avant
- Taper "`git commit -a -m "MettreUnCommentaireIci`" " (Je ne demande pas des commentaires ultra précis mais au moins de quoi comprendre ce qui a été changer)
- Taper "`git push NomDuProjet NomDeLaBranche`" (ici de préférence : "`git push origin master`")
- Taper vos identifiants git (Pseudo/MDP)

--------
**Ajouter un fichier sur le dépot git :**
- Toujours pareil
- Taper "`git add NomDuFichier`" ("`git add .`" permet de tout ajouter)
- Voir *Ajouter/Changements d'un fichier sur le dépot git*

--------
**Supprimer un fichier sur le dépot git :**
- T'as toujours pas compris?!
- Taper "`git rm NomDuFichier`" (Par pitiée pas de "`git rm .`" car ça efface TOUS les fichiers)
- Voir *Ajouter/Changements d'un fichier sur le dépot git*

--------
**Voir les branches existantes et changer de branche :**
- Taper "`git branch`" (Affiche les toutes les branches existantes)
- Taper "`git checkout NomDeLaBranche`" (Permet de se positionner dans la branche)

--------
**Créer une nouvelle branche / Voir les branches existantes :**
- Vérifier que la branche n'existe pas avant avec "`git branch`"
- Taper "`git branch NomDeLaNouvelleBranche`" (Création d'une branche, sans s'y positionner)
- Taper "`git checkout -b NomDeLaNouvelleBranche`" (Création d'une nouvelle branche en s'y positionnant)

--------
**Fusionner 2 branches :**
- Si vous voulez ajouter dans une branche A les mises à jour de la branche B
- Attention au conflits !
- Taper "`git checkout BrancheA`" (Positionnement dans la branche qui reçoit les changements)
- Taper "`git merge BrancheB`"  (Nom de la branche qui envoie les changements)

--------
**Mettre des changements temporairement en attente :**
- Pour revenir plus tard sur un travail non terminé
- ou un *pull* d'urgence pour débloquer quelqu'un 
- Taper "`git stash`" (Stocke dans la pile la branche en cours)

--------
**Réappliquer des changements en attente :**
- Pour revenir sur un travail non terminé en attente 
- Taper "`git stash list`" (Affiche la pile des modifs en attente)
- Taper "`git stash apply`" (Réapplique la dernière modif stockée mais la garde dans la pile)
- Taper "`git stash apply stash@{IdDeLaModif}`" (Réapplique la modif grâce à son ID mais la garde dans la pile)
- Taper "`git stash pop`" (Réapplique la dernière modif et la supprime de la pile)

--------
**Supprimer des changements dans la pile (*stash*) :**
- Taper "`git stash list`" (Affiche la pile des modifs en attente)
- Taper "`git stash drop stash@{IdDeLaModif}`" (Supprime la modif stockée par son ID de la pile)
- Taper "`git stash pop`" (Réapplique la dernière modif stockée et la supprime de la pile)
