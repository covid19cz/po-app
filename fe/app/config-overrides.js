const path = require("path");

const { alias } = require("react-app-rewire-alias");

module.exports = function override(config, env) {
  alias({
    "@": path.resolve(__dirname, "src"),
    "@swaggerBase": path.resolve(__dirname, "_api", "base", "dist", "api"),
    "@swaggerSecurity": path.resolve(
      __dirname,
      "_api",
      "security",
      "dist",
      "api"
    )
  })(config);

  return config;
};
