Speech Recognition Tool - Java

An offline speech-to-speech web search assistant for accessibility, especially for visually impaired users.

Features
- Voice input (CMU Sphinx)
- Web search (Jsoup + Google Search)
- Text-to-Speech (FreeTTS)
- Local logging (MySQL)
- Offline capable

How to Run
1. Install MySQL and run the SQL script.
2. Download `freetts.jar`, `jsoup-1.14.3.jar`, `mysql-connector-java.jar` into `/lib`.
3. Configure CMU Sphinx model under `resources/sphinx-config/` or use defaults.
4. Run `Main.java`.

Deployment
Offline Java Desktop Application. Optional: Convert to JAR and create installer.
