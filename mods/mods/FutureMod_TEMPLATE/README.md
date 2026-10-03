# Future Mod Template

Copy this folder and rename it to create another independent mod.

Then add the new folder name to `.github/workflows/build-mods.yml` under:

    matrix:
      mod:
        - ultimateores
        - your_new_mod

The copied mod must contain its own `build.gradle`, `gradle.properties`, `settings.gradle`, and `src/`.
