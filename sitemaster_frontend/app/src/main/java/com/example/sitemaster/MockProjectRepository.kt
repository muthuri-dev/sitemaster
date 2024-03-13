package com.example.sitemaster

class MockProjectRepository : ProjectRepository {
    override suspend fun getProjectDetails(projectName: String): Project? {
        // Simulate project details retrieval (replace with your actual logic)
        return if (projectName == "Project 1") {
            Project(
                projectName,
                "Description of project 1",
                listOf(
                    Worker("John Doe", "+1234567890"),
                    Worker("Jane Smith", "+9876543210")
                )
            )
        } else {
            null // Project not found
        }
    }
}
