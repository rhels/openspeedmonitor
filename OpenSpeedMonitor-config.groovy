/**
 * Move this file to one of the locations configured in config-setting grails.config.locations (see Config.groovy).
 * One of that locations is ~/.grails/OpenSpeedMonitor-config.groovy
 *
 * Settings in this file will override defaults in grails-app/config!
 *
 * @author nkuhn
 * @see Config.groovy
 * @see http://grails.org/doc/latest/guide/conf.html#configExternalized
 *
 */

//Configure default app users (bootstrapped on first start if not already in db -> see Bootstrap.groovy)
grails.de.iteratec.osm.security.initialOsmAdminUser.username='admin'
grails.de.iteratec.osm.security.initialOsmAdminUser.password='admin'
grails.de.iteratec.osm.security.initialOsmRootUser.username='root'
grails.de.iteratec.osm.security.initialOsmRootUser.password='root'

/*
*	Configure charting libraries available in OpenSpeedMonitor.
* 	Default is rickshaw, see http://code.shutterstock.com/rickshaw/
* 	Highcharts (http://www.highcharts.com/) is possible, too, but licensed proprietary.
*/
/** default charting lib */
grails.de.iteratec.osm.report.chart.chartTagLib = de.iteratec.osm.report.chart.ChartingLibrary.RICKSHAW
/** all available charting libs */
grails.de.iteratec.osm.report.chart.availableChartTagLibs = [de.iteratec.osm.report.chart.ChartingLibrary.RICKSHAW]
/** url to highchart's export server (for exporting charts as bitmaps or vector graphics). */
grails.de.iteratec.osm.report.chart.highchartsExportServerUrl = 'http://export.highcharts.com'

// MySQL DataSources
environments {
	development {
		dataSource {
			dbCreate = "update"// one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://mysql/osm"
			username = "osm"
			password = "osm"
			driverClassName = "com.mysql.jdbc.Driver"
			logSql = false
			pooled = true
			properties {
				minEvictableIdleTimeMillis = 60000
				timeBetweenEvictionRunsMillis = 5000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn = false
				validationQuery="SELECT 1"
			}
		}
	}
	production {
		grails.serverURL = "http://rhels.com:8080/OpenSpeedMonitor"
		dataSource {
			dbCreate = "update"// one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://mysql/osm"
			username = "osm"
			password = "osm"
			driverClassName = "com.mysql.jdbc.Driver"
			pooled = true
			properties {
				minEvictableIdleTimeMillis = 60000
				timeBetweenEvictionRunsMillis = 5000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn = false
				validationQuery="SELECT 1"
			}
		}
    }
}
