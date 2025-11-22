# Prerequisites

GCP Account with permissions to create Compute Engine VMs and VPCs.

Google Cloud Service Account JSON key downloaded locally.

Terraform installed (v1.5+ recommended).

Ansible installed (v2.10+ recommended).

WSL/Linux shell (or Linux/MacOS) for proper SSH key permissions.

Spark tarball: spark-2.4.3-bin-hadoop2.7.tgz downloaded locally.

# Step 1: Configure Terraform

Edit terraform/terraform.tfvars
Replace project_id and credentials_file with your project details.4

# Step 2: Provision GCP Infrastructure

cd terraform
terraform init
terraform plan
terraform apply

# Step 4: Configure Ansible Inventory

Edit ansible/inventory.ini:

# Step 5: Deploy Spark Cluster & WordCount

Run the playbook:
cd ansible
ansible-playbook -i inventory.ini deploy_spark_wordcount.yml
