(ns app.portfolio.scenes.button-scenes
  (:require
    [app.portfolio.utils :as u]
    [helix.core :as hc :refer [$]]
    [portfolio.react-18 :refer-macros [defscene]]
    ["@mantine/core" :as mt]))


(defscene simple-button
  ($ u/Provider {:defaultColorScheme "light"}
     ($ mt/Button "click me!!!")))

