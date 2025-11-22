# GCP Project and credentials
variable "project_id" {
}

variable "region" {
  default     = "europe-west1"
}

variable "zone" {
  default     = "europe-west1-b"
}

variable "credentials_file" {
}

# SSH for VM access
variable "ssh_user" {
  default     = "debian"  
}

variable "ssh_public_key_path" {
}

variable "worker_count" {
  default     = 2
}
