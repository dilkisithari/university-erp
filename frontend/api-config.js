/**
 * Shared API base URL for UniERP frontend pages.
 * Override before this script loads, or edit the fallback below.
 * Development fallback matches existing pages (students/courses use localhost:8080).
 */
// frontend/api-config.js
const API_BASE_URL = "https://university-erp-backend-app.azurewebsites.net/api";

console.log("✅ API Config Loaded - Base URL:", API_BASE_URL);

// Make it available globally
window.API_BASE_URL = API_BASE_URL;