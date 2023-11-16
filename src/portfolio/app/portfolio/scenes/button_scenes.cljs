(ns app.portfolio.scenes.button-scenes
  (:require
    [helix.core :as hc :refer [$]]
    [portfolio.react-18 :refer-macros [defscene]]
    ["@mantine/core" :as mt]))


(defscene simple-button
  ($ mt/MantineProvider {:defaultColorScheme "dark"}
     ($ mt/Button "click me!!!")))



(defscene simple-button2
  ($ mt/MantineProvider {:defaultColorScheme "light"}
     ($ mt/Button "click me!!!")))

