package fr.damnardev.gradle.plugins;

import org.gradle.api.Project;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.api.artifacts.VersionCatalog;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.provider.Provider;
import org.jspecify.annotations.NonNull;

import static org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME;

public class DependenciesConvention {

	private static @NonNull Provider<MinimalExternalModuleDependency> get(VersionCatalog libs, String alias) {
		return libs.findLibrary(alias)
		           .orElseThrow();
	}

	public void apply(Project project, VersionCatalog libs) {
		Provider<MinimalExternalModuleDependency> springBootBom = get(libs, "spring-boot-bom");
		Provider<MinimalExternalModuleDependency> swaggerUi = get(libs, "swagger-ui");

		DependencyHandler dependencies = project.getDependencies();
		dependencies.add(IMPLEMENTATION_CONFIGURATION_NAME, dependencies.platform(springBootBom));

		// To add a new dependency:
		// 1. Add version to gradle/libs.versions.toml: [libraries] section
		// 2. Add library definition to libs.versions.toml
		// 3. Add constraint
		// 4. Reference in module build.gradle: implementation libs.your.new.dependency

		dependencies.constraints(c -> c.add(IMPLEMENTATION_CONFIGURATION_NAME, swaggerUi));
	}

}
